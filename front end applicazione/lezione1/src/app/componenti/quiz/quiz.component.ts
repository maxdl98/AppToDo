import { CommonModule, JsonPipe, NgClass, NgIf } from '@angular/common';
import { Component, inject, NgModule } from '@angular/core';
import { FormBuilder, FormControl, FormControlName, FormGroup, FormGroupName, FormsModule, NgModel, NgModelGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatRecycleRows } from '@angular/material/table';
import { MatRadioModule } from '@angular/material/radio'; // <-- Assicurati che sia importato qui

@Component({
  selector: 'app-quiz',
  imports: [MatCardModule,MatCardModule,MatButtonModule,MatIconModule,FormsModule, ReactiveFormsModule, ReactiveFormsModule, JsonPipe, NgIf, NgClass,FormsModule,MatButtonModule,FormsModule,MatCardModule,MatButtonModule,MatRadioModule],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css'
})
export class QuizComponent {


submitQuiz() {
throw new Error('Method not implemented.');
}

q1! : FormControl
q2! : FormControl
q3! : FormControl
q4! : FormControl
q5! : FormControl


  toPsicologia : boolean = false; 

  ToNext : boolean = false;

  toSociologia: boolean = false;
   
  toGeografia: boolean = false;

  toArte: boolean = false;

  toInformatica: boolean = false;

quizForm!: FormGroup

  quizSubmitted : boolean = false;


quizform = new FormGroup({
   q1 : new FormControl('', Validators.required),
  q2 : new FormControl(''),
  q3 : new FormControl(''),
  q4 : new FormControl(''),
  q5 : new FormControl(''),
   
  
  
})
  

  avanti(){
    this.ToNext = true
  }

  onNextStep(){
   this.toPsicologia = true;
  }

  onNextSociologia(){
  this.toSociologia = true;
  }

  onNextGeografia(){
  this.toGeografia = true;
  }

  onNextToArte(){
   this.toArte = true
  }

  onNextStopInformatica(){
    this.toInformatica = true
  }








}
