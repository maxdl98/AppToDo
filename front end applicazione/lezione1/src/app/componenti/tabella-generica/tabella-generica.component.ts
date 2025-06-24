import { ChangeDetectionStrategy, Component, ElementRef, inject, Input, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButton, MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { AuthserviceService } from '../../auth/authservice.service';
import {MatDialog, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogModule, MatDialogTitle} from '@angular/material/dialog';
import { setTimeout } from 'node:timers/promises';
import { DialogComponent } from '../dialog/dialog.component';
import { Router } from '@angular/router';


@Component({
  selector: 'app-tabella-generica',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButton,
],
  templateUrl: './tabella-generica.component.html',
  styleUrls: ['./tabella-generica.component.css']
})
export class TabellaGenericaComponent implements OnInit {
   showForm = true;
   
   mostraPagina = false;

  constructor(private service:AuthserviceService, private element:ElementRef, private route:Router){

  }


  dataSource: any[] = [];

    urlEmail = "http://localhost:8080/api/utenti/sendHtmlEmail"



  formGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.pattern(/^(?=.*[!@#$%^&*()_+\[\]{};':"\\|,.<>\/?-]).{9,}$/)
    ])
  });

  ngOnInit(): void {
 

  }

  onSubmit(): void {
    
   
      this.showForm = false
      

      
     


    
    this.service.sendEmail(this.urlEmail, this.formGroup.value.email as string)
    .subscribe(data =>{
    console.log(data);
    
     
    })

    
    

 
     

  }


  onSubmit2(){
    
   this.mostraPagina = true;

   this.route.navigate(['dash' , 'paginanuova']); // ✅ GIUSTO: è un array
  

  }  

  




}


