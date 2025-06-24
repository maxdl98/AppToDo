import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import { AuthserviceService } from '../../auth/authservice.service';
import { Router } from '@angular/router'; // CORRETTO


@Component({
  selector: 'app-createticket',
  imports: [ReactiveFormsModule,MatInputModule,CommonModule,MatSelectModule],
  templateUrl: './createticket.component.html',
  styleUrl: './createticket.component.css'
})
export class CreateticketComponent implements OnInit {
  dati: any;

  
  mostraInfo : boolean = false;

  constructor(private service:AuthserviceService, private route:Router) {
    
  }


   ngOnInit(): void {
    const email = localStorage.getItem('email')

    if(email) {
      this.emailUtente = JSON.parse(email);
    }
  }
   
  selectedFile : File | null = null;
  
   emailUtente:string =  "";

   InvioDati = new FormGroup({
    problematica : new FormControl('',Validators.required),
    contenuto : new FormControl('',Validators.required),
   })


   onFileSelected(event:any){
    this.selectedFile = event.target.files[0]
   }

    
    

   onSubmit(){
  const dati = {
    email       : this.emailUtente,
    problematica: this.InvioDati.value.problematica!,
    contenuto   : this.InvioDati.value.contenuto!,
    file        : this.selectedFile || undefined
  };

  this.service.submitTicketData(dati)
    .subscribe({
      next: res => console.log('Ticket inviato:', res),
      error: err => console.error('Errore invio ticket:', err)
    });

    this.mostraInfo = true;



}


goHome(){
  this.route.navigate(['dash'])
}

   }













 




    

