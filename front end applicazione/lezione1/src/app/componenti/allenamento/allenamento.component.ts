import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-allenamento',
  imports: [],
  templateUrl: './allenamento.component.html',
  styleUrl: './allenamento.component.css'
})
export class AllenamentoComponent implements OnInit {
  ngOnInit(): void {
    
  const primo$ = new Observable( observer =>{
     observer.next('Ciao')
     observer.next('Come va? ')
     observer.complete();
  })

  primo$.subscribe({
    next: val => console.log('Valore', val)
  })
  }









}
