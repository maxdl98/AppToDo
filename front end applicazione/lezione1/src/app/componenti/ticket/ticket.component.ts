import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSidenav, MatSidenavModule } from '@angular/material/sidenav';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ticket',
  imports: [MatLabel,CommonModule,MatSidenavModule,MatFormFieldModule,ReactiveFormsModule,MatInputModule,MatIconModule],
  templateUrl: './ticket.component.html',
  styleUrl: './ticket.component.css'
})
export class TicketComponent implements OnInit {
  
  emailUtente : string = "";
  mostra : boolean = false;

   constructor(private route:Router){}
  ngOnInit(): void {
    const email = localStorage.getItem('email')

    if(email){
     this.emailUtente = email;
    }
  }


  onLogout(){
    this.route.navigate(['login'])
  }

   onHome(){
    this.route.navigate(['dash'])
   }
  
    
   mostraTicks(){

    this.mostra = true;

     setTimeout(() => {
    this.mostra = false;
  }, 10000);





}

goComponent2(){
   this.route.navigate(['createticket'])
}

toTicketChiusi(){
  this.route.navigate(["ticketchiusi"])
}



}



