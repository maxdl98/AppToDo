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


@Component({
  selector: 'app-login-admin',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule, FotologinAdminComponent,ProgressSpinnerComponent],
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit,AfterViewInit {

  visibleSpinner: boolean = false;

  emailMia : string = "delucamassimo9880@gmail.com"

  adminForm!: FormGroup;

  constructor(private service: AuthserviceService, private route: Router, private cd: ChangeDetectorRef) {}
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


   



  onSubmit() {

     this.visibleSpinner = true; 
    if (this.adminForm.invalid) return;

    const email = this.adminForm.get('email')?.value;
    const password = this.adminForm.get('password')?.value;

    console.log("Email:", email);
    console.log("Password:", password);

    this.service.loginAdmin(email, password).subscribe(data => {
      console.log("Risposta:", data)

       this.service.isAdmin = true;

       localStorage.setItem('isAdmin','true')
       
       if(this.service.isAdmin){
        this.route.navigate(['gestisciticket'])
       }


     
    });

  }


  get  ControlloEmail() {
    return this.adminForm.get('email')
  }
}
