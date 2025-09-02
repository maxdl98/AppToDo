import { CommonModule } from '@angular/common';
import { Component, ElementRef, OnInit, ViewEncapsulation } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { NavigationEnd, Router, RouterModule } from '@angular/router'; // CORRETTO
import { filter } from 'rxjs';


@Component({
  selector: 'app-pagina1',
  imports: [MatCardModule,MatToolbarModule,MatIconModule,CommonModule,RouterModule,MatToolbarModule],
  templateUrl: './pagina1.component.html',
  standalone : true,
  styleUrl: './pagina1.component.css',
  encapsulation: ViewEncapsulation.None
})
export class Pagina1Component implements OnInit {

 constructor(private router:Router){}




  ngOnInit(): void {
  this.router.events.pipe(
    filter(e => e instanceof NavigationEnd)
  ).subscribe(() => {
    // Aspetta il rendering del DOM prima dello scroll
    setTimeout(() => {
      const element = document.getElementById('garibaldi');
      if (element) {
        element.scrollIntoView({ behavior: 'smooth' });
      }
    }, 0); // oppure 100ms se ancora non funziona
  });
}


goToGaribaldi(){

  const garibaldiParagrafo = document.getElementById('garibaldi');


  if(garibaldiParagrafo){
        garibaldiParagrafo.scrollIntoView({ behavior: 'smooth', block: 'start' });

  }

  
}
  


  
 

 
 
}
