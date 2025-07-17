import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatFormField, MatFormFieldControl, MatLabel } from '@angular/material/form-field';
import { AuthserviceService } from '../../auth/authservice.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-recupero-password',
  imports: [MatFormField,MatLabel,ReactiveFormsModule,CommonModule],
  templateUrl: './recupero-password.component.html',
  styleUrl: './recupero-password.component.css'
})
export class RecuperoPasswordComponent implements OnInit{
  recuperoPassword! : FormGroup



  constructor(private service:AuthserviceService){}
  ngOnInit(): void {
    

    this.recuperoPassword = new FormGroup({
        passwordVecchia : new FormControl(''),
        passwordNuova : new FormControl('')


    })


  }


  cambioPassword(){

    const passwordVecchia = this.recuperoPassword.get('passwordVecchia')?.value
    const passwordNuova = this.recuperoPassword.get('passwordNuova')?.value

    console.log(passwordVecchia)

    console.log(passwordNuova)

    const duo = {
      passwordVecchia1 : passwordVecchia,
      passwordNuova2 : passwordNuova
    }


    this.service.cambioPass(duo).subscribe(data =>{
       console.log(data)
    })


  }




}
