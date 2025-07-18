import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatFormField, MatFormFieldControl, MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { AuthserviceService } from '../../auth/authservice.service';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { Subscription } from 'rxjs';
import { FotoRecuperoPasswordComponent } from '../foto-recupero-password/foto-recupero-password.component';
import {  MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { SnackbarSuccessComponent } from '../snackbar-success/snackbar-success.component';
import { SnackbarErrorComponent } from '../snackbar-error/snackbar-error.component';

@Component({
  selector: 'app-recupero-password',
  standalone: true,
  imports: [MatFormField,MatLabel,ReactiveFormsModule,CommonModule,MatFormFieldModule,MatInputModule,FotoRecuperoPasswordComponent,MatSnackBarModule],
  templateUrl: './recupero-password.component.html',
  styleUrls: ['./recupero-password.component.css']
})
export class RecuperoPasswordComponent implements OnInit, OnDestroy{
  

  

subscriptionCambioPass!: Subscription;

  recuperoPassword! : FormGroup

  pass1 : any;

  pass2: any;

  constructor(private service:AuthserviceService, private snackBar:MatSnackBar, private router:Router){}


  
  ngOnDestroy(): void {
    if(this.subscriptionCambioPass){
  this.subscriptionCambioPass.unsubscribe();
    }
  }



  ngOnInit(): void {
    

    this.recuperoPassword = new FormGroup({
        passwordVecchia : new FormControl(''),
        passwordNuova : new FormControl('')


    })


  }


  cambioPassword(){


    
  
    const passwordVecchia = this.recuperoPassword.get('passwordVecchia')?.value
    const passwordNuova = this.recuperoPassword.get('passwordNuova')?.value

    
    const oggetto = {
      vecchiaPassword  : passwordVecchia,
      nuovaPassword : passwordNuova
    }

    console.log(oggetto)
   

this.subscriptionCambioPass = this.service.cambioPass(oggetto).subscribe({
  next: (data) => {
     this.snackBar.openFromComponent(SnackbarSuccessComponent, {
     data: 'La password è stata cambiata',
     duration: 2000,
     panelClass: ['snackbar-success']
   });;
   
   
    this.router.navigate(['loginAdmin'])
    
  },
  error: (error: any) => {
    console.error('Errore:', error);

    if (error.status === 400) {
        this.snackBar.openFromComponent(SnackbarErrorComponent, {
                data:'La password precedente è uguale a quella nuova. Si prega di cambiare ',
                duration: 2000,
                panelClass: ['rispostasbagliata']
              })
    } else {
      this.snackBar.openFromComponent(SnackbarErrorComponent, {
          data:'Password precedente non corretta',
          duration: 2000,
          panelClass: ['rispostasbagliata']
        })
    }
  }
});





    }



    tornaLogin(){
      this.router.navigate(['loginAdmin'])
    }










  }

  
    





