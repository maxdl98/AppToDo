import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import {MatFormFieldControl, MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { ErroreService } from '../../auth/errore.service';
import { AuthserviceService } from '../../auth/authservice.service';
import {jwtDecode} from 'jwt-decode';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  imports: [MatFormFieldModule, CommonModule, ReactiveFormsModule,MatInputModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {



  constructor(private errore:ErroreService,private service:AuthserviceService, private route:Router){
     errore.erroreMessaggio()
  }




  ngOnInit(): void {

  }


  userForm = new FormGroup({
 email: new FormControl('', [Validators.required]),
 password: new FormControl('',[Validators.required, Validators.minLength(4), Validators.pattern('[!@#$%^&*(),.?":{}|<>]')])

  })


  onSubmit(){
     const email = this.userForm.value.email as any
     const password = this.userForm.value.password as any
     console.log(email,password)
     this.service.login(email,password).subscribe({
      next: (data:any) =>{
       console.log(data);
       const token = data.token
           const decodedToken: any = jwtDecode(token);
          console.log('Scadenza:', new Date(decodedToken.exp * 1000));
          const dataScadenza = new Date(decodedToken * 1000);
         this.service.createUser(data.email,data.id,data.token,data.nome);
          console.log("ecco l'user" , this.service.user)
          localStorage.setItem('email', JSON.stringify(email));
          localStorage.setItem('user', JSON.stringify(this.service.user));
          localStorage.setItem('token', JSON.stringify(this.service.user.token))
          this.route.navigate(['dash'])


      },

      error: (err) => {
        console.log(err);
      }
     })

  }


  onSignIn(){
    this.route.navigate(['signin'])
  }
}



