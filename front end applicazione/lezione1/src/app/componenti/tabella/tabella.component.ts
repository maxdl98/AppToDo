import { Component } from '@angular/core';
import {MatTableModule} from '@angular/material/table';

@Component({
  selector: 'app-tabella',
  imports: [MatTableModule],
  templateUrl: './tabella.component.html',
  styleUrl: './tabella.component.css'
})
export class TabellaComponent {
   
  totalePersone! : number;
  discipilina! : string;
  lavoro! : string;
   
 ElementData  = [
  {  disciplina: "Sociologia" , totalePersone : 600 , lavoro : "Si"  },
  {  disciplina: "Filosofia" , totalePersone : 900 , lavoro : 'Si' },
  { disciplina: "Informatica" , totalePersone : 900 , lavoro : 'Si' },
  {  disciplina: "Matematica", totalePersone : 1000, lavoro : 'Si'},
  {  disciplina: "Lingue Straniere" , totalePersone : 400 , lavoro : 'Si'},
  { disciplina: "Psicologia" , totalePersone : 550 , lavoro : 'Si'}
];

 dataSource = this.ElementData

displayedColumns : string[] = ['disciplina', 'totalePersone', 'lavoro']





}
