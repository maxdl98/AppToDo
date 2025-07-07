import { CommonModule, JsonPipe, NgClass, NgIf } from '@angular/common';
import { Component, inject, NgModule } from '@angular/core';
import { FormBuilder, FormControl, FormControlName, FormGroup, FormGroupName, FormsModule, NgModel, NgModelGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatRecycleRows } from '@angular/material/table';
import { MatRadioModule } from '@angular/material/radio'; // <-- Assicurati che sia importato qui
import { AuthserviceService } from '../../auth/authservice.service';

@Component({
  selector: 'app-quiz',
  imports: [MatCardModule,MatCardModule,MatButtonModule,MatIconModule,FormsModule, ReactiveFormsModule, ReactiveFormsModule, JsonPipe, NgIf, NgClass,FormsModule,MatButtonModule,FormsModule,MatCardModule,MatButtonModule,MatRadioModule,CommonModule],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css'
})
export class QuizComponent {

constructor(private service:AuthserviceService){

}


risposta1! : FormControl
risposta2! : FormControl
risposta3! : FormControl
risposta4! : FormControl
risposta5! : FormControl
risposta6! : FormControl


  toPsicologia : boolean = false; 

  ToNext : boolean = true;

  toSociologia: boolean = false;
   
  toGeografia: boolean = false;

  toArte: boolean = false;

  toInformatica: boolean = false;


  quizSubmitted : boolean = false;


quizForm = new FormGroup({
   risposta1 : new FormControl('', Validators.required),
  risposta2: new FormControl('', Validators.required),
  risposta3 : new FormControl('', Validators.required),
  risposta4 : new FormControl('',Validators.required),
  risposta5 : new FormControl('', Validators.required),
  risposta6: new FormControl('', Validators.required)
   
  
  
})


submitQuiz() {

    const risposte = {
    risposta1: this.quizForm.value.risposta1,
    risposta2: this.quizForm.value.risposta2,
    risposta3: this.quizForm.value.risposta3,
    risposta4: this.quizForm.value.risposta4,
    risposta5: this.quizForm.value.risposta5,
    risposta6: this.quizForm.value.risposta6
  };
 
  
 
  this.service.inviaQuiz(risposte).subscribe({
    next: (data : any) => {
      console.log(data);
    }
  })
  
  
}



  

  avanti(){
    this.ToNext = true
  }

  onNextStep(){
    let risposta1 = this.quizForm.get('risposta1')?.valid
    if(risposta1){
    this.toPsicologia = true
     
    } 
  }

  onNextSociologia(){
        let risposta2 = this.quizForm.get('risposta2')?.valid

     if(risposta2){
       this.toSociologia = true

    }
  }

  onNextGeografia(){
    let risposta3 = this.quizForm.get('risposta3')?.valid

   if(risposta3){
       this.toGeografia = true

    }
  }

  onNextToArte(){
    let risposta4 = this.quizForm.get('risposta4')?.valid

    if(risposta4){
      this.toArte = true
    }
  }

  onNextStopInformatica(){
        let risposta5 = this.quizForm.get('risposta4')?.valid

     if(risposta5){
        this.toInformatica = true

    }
  }








}
