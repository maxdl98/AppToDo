import { AfterViewInit, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthserviceService } from '../../auth/authservice.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FotologinAdminComponent } from '../fotologin-admin/fotologin-admin.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { ProgressSpinnerComponent } from '../progress-spinner/progress-spinner.component';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpStatusCode } from '@angular/common/http';
import { SnackbarSuccessComponent } from '../snackbar-success/snackbar-success.component';
import { SnackbarErrorComponent } from '../snackbar-error/snackbar-error.component';


@Component({
  selector: 'app-login-admin',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule, FotologinAdminComponent,ProgressSpinnerComponent,MatSnackBarModule],
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit,AfterViewInit {

  visibleSpinner: boolean = false;

  emailMia : string = "delucamassimo9880@gmail.com"

  adminForm!: FormGroup;

  constructor(private service: AuthserviceService, private route: Router, private cd: ChangeDetectorRef, private snackbar:MatSnackBar) {}
  ngAfterViewInit() {
  setTimeout(() => {
    this.cd.detectChanges();
  }, 0);
}

  ngOnInit() {
    this.adminForm = new FormGroup({
      email: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(4)])
    });
  }


   toPasswordVecchia(){
    if(this.service.isAdmin){
      this.route.navigate(['passwordVecchia'])
    }
   }



  onSubmit() {

    if (this.adminForm.invalid) return;
    
    this.visibleSpinner = true

    

    const email = this.adminForm.get('email')?.value;
    const password = this.adminForm.get('password')?.value;

    console.log("Email:", email);
    console.log("Password:", password);

    this.service.loginAdmin(email, password).subscribe({
      next: (data) => {
        
        

        
 

      console.log("Risposta:", data)

  

       this.service.isAdmin = true;

       localStorage.setItem('isAdmin','true')


       setTimeout(() => {
         if(this.service.isAdmin){
        this.route.navigate(['gestisciticket'])
       }
       }, 3000);
      
      }, 
      error: (error:any) => {
        this.visibleSpinner = false;

        this.snackbar.openFromComponent(SnackbarErrorComponent, {
          data:'Password non corretta',
          duration: 2000,
          panelClass: ['rispostasbagliata']
        })
        
      }
      


     
    });

  }


  get  ControlloEmail() {
    return this.adminForm.get('email')
  }
}
