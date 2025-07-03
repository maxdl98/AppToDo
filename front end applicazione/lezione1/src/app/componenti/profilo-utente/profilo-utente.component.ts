import { Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatDrawerContainer, MatDrawerContent } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { AppComponent } from "../../app.component";

@Component({
  selector: 'app-profilo-utente',
  imports: [MatToolbarModule, MatIconModule, RouterLink, MatDrawerContainer, MatDrawerContent, AppComponent,RouterOutlet],
  templateUrl: './profilo-utente.component.html',
  styleUrl: './profilo-utente.component.css'
})
export class ProfiloUtenteComponent  {


  constructor(private route:Router){}
  

    
  



}
