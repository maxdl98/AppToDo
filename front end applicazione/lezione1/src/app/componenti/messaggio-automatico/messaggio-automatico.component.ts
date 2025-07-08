import { Component, Input, OnInit, Output } from '@angular/core';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import { QuizComponent } from '../quiz/quiz.component';
import { EventEmitter} from '@angular/core';

@Component({

  selector: 'app-messaggio-automatico',
  imports: [MatCardModule, MatChipsModule, MatProgressBarModule],
  standalone : true,
  templateUrl: './messaggio-automatico.component.html',
  styleUrl: './messaggio-automatico.component.css'
})
export class MessaggioAutomaticoComponent implements OnInit {
  ngOnInit(): void {
    console.log(this.longText)
  }

  @Input() longText: string = "Grazie per aver completato il quiz. Un formatore la contatterà quanto prima per annunciarle il voto";





 


}
