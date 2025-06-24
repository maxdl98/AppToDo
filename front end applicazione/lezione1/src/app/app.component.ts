import { CommonModule, NgFor } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EsercizioComponent } from "./componenti/esercizio/EsercizioComponent";
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { LoginComponent } from "./componenti/login/login.component";
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NgFor, CommonModule, FormsModule, EsercizioComponent, LoginComponent,MatIconModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent  {
  title = 'lezione1';

  mostrare = false






  change(){
    this.mostrare = !this.mostrare
  }

  


 



  
 


}
