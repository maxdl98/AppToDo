import { CommonModule, JsonPipe, NgClass, NgFor, NgIf } from '@angular/common';
import { Component, inject, Input, NgModule, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormControlName, FormGroup, FormGroupName, FormsModule, NgModel, NgModelGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatRecycleRows } from '@angular/material/table';
import { MatRadioModule } from '@angular/material/radio'; // <-- Assicurati che sia importato qui
import { AuthserviceService } from '../../auth/authservice.service';
import { MessaggioAutomaticoComponent } from "../messaggio-automatico/messaggio-automatico.component";
import { EventEmitter } from 'stream';
import { MatChipsModule } from '@angular/material/chips';
import { AuthService } from '../../token/auth.service';
import { HttpClient } from '@angular/common/http';
import { Domande, Risposta, Utente} from '../../interfacce/interfacce';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';

@Component({
  selector: 'app-quiz',
  imports: [MatCardModule, MatCardModule, MatButtonModule, MatIconModule, FormsModule, ReactiveFormsModule, ReactiveFormsModule, JsonPipe, NgIf, NgClass, FormsModule, MatButtonModule, FormsModule, MatCardModule, MatButtonModule, MatRadioModule,CommonModule,MessaggioAutomaticoComponent,MatInputModule,MatCheckboxModule],
  standalone: true,
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css'
})
export class QuizComponent implements OnInit {
  id2! : Utente 

  idDomanda! : number[]
  fineQuiz : boolean = false;

    risposteSelezionate: { idDomanda: number; risposta: Risposta }[] = [];


  domande! : Domande[];
  currentIndex = 0;
  id! : number[];
  testoDomanda! : string[];
  materia! : string[];
  listaRisposte! : Risposta[]

  risposte!:Risposta[]


 constructor(private service:AuthserviceService, private http:HttpClient){

 }
  ngOnInit(): void {
    this.service.randomQuestion().subscribe((data : Domande[]) => {

  
      this.domande = data
    
      console.log(this.domande)

      this.currentIndex = 0;


       
     
      

      
      const userString = localStorage.getItem('userId')

        if(userString){
          this.id2 = JSON.parse(userString)
        }





          

        
       
   




    });

       

    
    
    


    

  
    }

   toggleSelezione(risposta: Risposta, checked: boolean) {

     

   }


     prossimaDomanda() {
    if (this.currentIndex < this.domande.length - 1) {
      this.currentIndex++;
      
     
    }

    
  }

  domandaPrecedente() {
    if (this.currentIndex > 0) {
      this.currentIndex--;
    }
  }

   


    



}





