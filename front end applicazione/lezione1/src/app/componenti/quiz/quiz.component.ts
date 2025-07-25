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
import { Domande, Risposta, Utente, RisposteSelezionate} from '../../interfacce/interfacce';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';

@Component({
  selector: 'app-quiz',
  imports: [MatCardModule, MatCardModule, MatButtonModule, MatIconModule, FormsModule, ReactiveFormsModule, ReactiveFormsModule, NgIf, NgClass, FormsModule, MatButtonModule, FormsModule, MatCardModule, MatButtonModule, MatRadioModule,CommonModule,MatInputModule,MatCheckboxModule],
  standalone: true,
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css'
})
export class QuizComponent implements OnInit {

  id2! : Utente 

  idDomanda! : number
  fineQuiz : boolean = false;



  risposteSelezionate! : RisposteSelezionate 


  domande! : Domande[];
  currentIndex = 0;
  id! : number[];
  testoDomanda! : string[];
  materia! : string[];
  listaRisposte! : Risposta[]

  risposte!:Risposta[]

  risposteUtente : { [idDomanda: number]: number } = {};


 constructor(private service:AuthserviceService, private http:HttpClient){

 }
  ngOnInit(): void {
    const userString = localStorage.getItem('userId');

   if (userString) {
  try {
    const idParsed = JSON.parse(userString);
    this.id2 = typeof idParsed === 'number'
      ? { id: idParsed } as Utente
      : idParsed;

    console.log("Utente caricato:", this.id2);
  } catch (e) {
    console.error("Errore parsing userId:", e);
  }
}
// metodi API Richieste 

    this.service.randomQuestion().subscribe((data : Domande[]) => {

  
      this.domande = data
    
      console.log(this.domande)

      this.currentIndex = 0;

     
    });
  
    }


  toggleSelezione(domanda: Domande, risposta: Risposta) {
    const idUtente = this.id2.id;
    const idDomanda = domanda.id;
    const idRisposta = risposta.id;

    if (this.risposteUtente[idDomanda] === idRisposta) {
    delete this.risposteUtente[idDomanda];
  } else {
    this.risposteUtente[idDomanda] = idRisposta;
  }

  console.log(`Utente: ${idUtente}, Domanda: ${idDomanda}, Risposta: ${this.risposteUtente[idDomanda]}`);

}



  prossimaDomanda() {
  const domandaCorrente = this.domande[this.currentIndex];
  const idDomanda = domandaCorrente.id;
  const idUtente = this.id2.id;

  const idRispostaSelezionata = this.risposteUtente[idDomanda];

  if (idRispostaSelezionata === undefined) {
    console.warn("Nessuna risposta selezionata per questa domanda.");
    return; // oppure puoi mostrare un messaggio per forzare la selezione
  }

  // Trova la risposta completa per ottenere il flag
  const rispostaSelezionata = domandaCorrente.listaRisposte.find(
    r => r.id === idRispostaSelezionata
  );

  if (!rispostaSelezionata) {
    console.error("Risposta non trovata.");
    return;
  }

  const body = {
    punteggio: {
      utente: {
        id: idUtente
      }
    },
    id: idDomanda,
    flag: rispostaSelezionata.flag
  };

  this.service.savePunteggio(body).subscribe({
    next: (response) => {
      console.log("Punteggio aggiornato", response);

      // Vai avanti solo se è stata salvata la risposta
      if (this.currentIndex < this.domande.length - 1) {
        this.currentIndex++;
      } else {
        this.fineQuiz = true; 
        console.log('finish')
      }
    },
    error: (err) => {
      console.error("Errore nel salvataggio del punteggio", err);
    }
  });
}



domandaPrecedente() {
    if (this.currentIndex > 0) {
      this.currentIndex--;
    }
  }


isChecked(domanda: Domande, risposta: Risposta): boolean 
{
  return this.risposteUtente[domanda.id] === risposta.id;
  
}






}
