import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
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
      const element = document.getElementById('garibaldi');

      if(element){
        element.scrollIntoView({behavior: 'smooth'})
      }
    })
  }
  


  
 

 
 
}
