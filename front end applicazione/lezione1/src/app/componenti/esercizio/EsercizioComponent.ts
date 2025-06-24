import { CommonModule, NgFor, NgIf } from '@angular/common';
import { Component, ElementRef, Input, OnInit } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';  // Importa FormsModule
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { IconType } from '@angular/material/icon/testing';
import { AuthserviceService } from '../../auth/authservice.service';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';


@Component({
  selector: 'app-esercizio',
  imports: [CommonModule,NgIf,FormsModule,NgFor,MatIconModule,MatToolbarModule,MatButtonModule],
  standalone : true,
  templateUrl: './EsercizioComponent.html',
  styleUrl: './esercizio.component.css'
})
export class EsercizioComponent implements OnInit {
  taskCorrente: any;
   
   

  constructor(private service:AuthserviceService){

  }


  ngOnInit(): void {
   
  }

  tasks : any[] = []

  @Input() elemento!: ElementRef;

  bloccare : boolean = true;

  task : string = ""

   colore : boolean = false

  completato(index : number){
  
    this.colore = !this.colore
  
     
    
  }   

  aggiungiTask(){

    
    this.tasks.push(this.task);

    this.task = ""

    

  }


  get lunghezzaCaratteri(){
    return this.task.length
  }


  rimuoviTask(index: number) {
    return this.tasks.splice(index,1)
  }


  moveUp(index: number){
    if(index > 0){
      const taskPrima = this.tasks[index - 1]

      this.tasks[index - 1] = this.tasks[index];

      this.tasks[index] = taskPrima;


    }
  }

  moveDown(index: number) {
  if (index < this.tasks.length - 1) {
    const task = this.tasks[index];
    this.tasks[index] = this.tasks[index + 1];
    this.tasks[index + 1] = task;
  }
}


 
}