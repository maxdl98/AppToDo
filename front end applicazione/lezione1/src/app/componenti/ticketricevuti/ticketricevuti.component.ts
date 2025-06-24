import { Component, OnInit } from '@angular/core';
import { FormsModule, NgControl, NgModel } from '@angular/forms';
import { MatFormFieldControl, MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import {MatTabsModule} from '@angular/material/tabs';
import { AuthserviceService } from '../../auth/authservice.service';
import { MatTableModule } from '@angular/material/table';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { MatOption, MatSelectModule } from '@angular/material/select';
import { Route } from '@angular/router';
import { Router } from '@angular/router';
import { NavComponent } from "../nav/nav.component";



@Component({
  selector: 'app-ticketricevuti',
  imports: [FormsModule, MatFormFieldModule, MatInputModule, MatTabsModule, MatTableModule, MatInputModule, NgIf, NgFor, MatOption, MatFormFieldModule, MatSelectModule, CommonModule, NavComponent,NavComponent],
  templateUrl: './ticketricevuti.component.html',
  styleUrl: './ticketricevuti.component.css'
})
export class TicketricevutiComponent implements OnInit {
  urlTicketsGetAll = "http://localhost:8080/api/tickets/getAllEmail"
  showForm : boolean = false
  displayedColumns: string[] = [ 'problematica','email', 'contenuto', 'azioni'];

  libriDisponibili = 
    ["L'arte del saper vivere","La società senza consumi","Cos'è la libertà?"]
    



  selectedEmail : string = "";
  selectContenuto : string = "";
  selectedProblematica : string = "";


  nomeOperatore : string = "";
  risposta : string = "";
  libroSelezionato: string = '';

  dataEmail : string  = "";

   dataSource:any[] = []
 constructor(private service:AuthserviceService, private route:Router){

 }
  ngOnInit(): void {
   this.service.getAllEmail(this.urlTicketsGetAll).subscribe
   (data =>{
    this.dataSource = data as any
    console.log(data);
   })



  }

  onAction(element : any){
   this.selectedEmail = element.email;
   this.selectedProblematica = element.problematica;
   this.selectContenuto = element.contenuto;
   this.showForm = true
   console.log(this.selectedEmail);
    
   

  }

  chiudiForm(){
    this.showForm = false;
  }


  inviaDati2(){
    this.showForm = false;
    this.service.invioMail2(this.selectedEmail,{
      nome: this.nomeOperatore,
      risposta: this.risposta,
      libriDisponibili: this.libroSelezionato,
    }).subscribe(data =>{
      console.log(data);
    })
  }







}
