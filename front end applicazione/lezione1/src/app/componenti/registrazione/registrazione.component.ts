import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Form, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { AuthserviceService } from '../../auth/authservice.service';
import { HttpClient } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router'; // CORRETTO
import { LoginComponent } from '../login/login.component';
import { MatOption, MatSelectModule } from '@angular/material/select';


@Component({
  selector: 'app-registrazione',
  imports: [ReactiveFormsModule,MatInputModule,CommonModule,RouterModule,LoginComponent,MatSelectModule,MatOption],
  templateUrl: './registrazione.component.html',
  styleUrl: './registrazione.component.css'
})
export class RegistrazioneComponent {

  constructor(private service:AuthserviceService, private http:HttpClient, private route:Router){}
  
  
  data! : any
  nome!:any
  email! : any
  password!: any
  regione!:any
  telefono!:any

    urlTelefono = "http://localhost:8080/api/utenti/Messaggio"



  datiUser! : {}

  userForm = new FormGroup({
    nome : new FormControl(''),
    email : new FormControl('',Validators.email),
    data: new FormControl('', Validators.required),
    numero: new FormControl(''),
    regione: new FormControl(''),
    password: new FormControl('', [Validators.minLength(8), Validators.pattern('[!@#$%^&*(),.?":{}|<>]')]),
  })











  


  onSubmit() {
  const data = this.userForm.value.data;
  const nome = this.userForm.value.nome;nome
  const email = this.userForm.value.email;
  const regione = this.userForm.value.regione;
  const password = this.userForm.value.password;
  const numero = this.userForm.value.numero
  

  this.service.signUp({nome, email, data,numero,regione,password, returnSecureToken: true}

  
  
 
  



  ).subscribe(data =>{
    console.log(data)



  })

 
   
  

   this.route.navigate(['login'])

}


redirectToLogin(){
  this.route.navigate(['login']);
}



 



}
