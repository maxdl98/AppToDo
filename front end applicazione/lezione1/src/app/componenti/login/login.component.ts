import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ErroreService } from '../../auth/errore.service';
import { AuthserviceService } from '../../auth/authservice.service';
import {jwtDecode} from 'jwt-decode';  // corretto import
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [MatFormFieldModule, CommonModule, ReactiveFormsModule, MatInputModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private errore: ErroreService, private service: AuthserviceService, private route: Router) {
    errore.erroreMessaggio();
  }

  ngOnInit(): void { }

  userForm = new FormGroup({
    email: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.minLength(4), Validators.pattern('[!@#$%^&*(),.?":{}|<>]')])
  });

  onSubmit() {
    const email = this.userForm.value.email as any;
    const password = this.userForm.value.password as any;
    console.log(email, password);
    this.service.login(email, password).subscribe({
      next: (data: any) => {
        console.log(data);
        const token = data.token;
       
        if (typeof token !== 'string' || !token) {
          console.error('Token non valido:', token);
          return;
        }

        const decodedToken: any = jwtDecode(token);
        console.log('Scadenza:', new Date(decodedToken.exp * 1000));
        const dataScadenza = new Date(decodedToken.exp * 1000);

        this.service.createUser(data.email, data.id, token, data.nome);
        console.log("ecco l'user", this.service.user);

        localStorage.setItem('loginTimestamp', (decodedToken.iat * 1000).toString());
        localStorage.setItem('userId', data.id.toString()); 

        localStorage.setItem('email', JSON.stringify(email));
        localStorage.setItem('user', JSON.stringify(this.service.user));
        localStorage.setItem('token', token);  // senza stringify

        this.route.navigate(['dash']);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  onSignIn() {
    this.route.navigate(['signin']);
  }
}
