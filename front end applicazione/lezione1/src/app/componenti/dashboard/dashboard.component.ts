type Lang = 'it' | 'en'; // ✅ dichiarazione corretta

import { Component } from '@angular/core';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListItem, MatListModule } from '@angular/material/list';
import { Route, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { MatToolbar, MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButton, MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { link } from 'fs';
import { CreateticketComponent } from '../createticket/createticket.component';
import { NavComponent } from "../nav/nav.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    MatSidenavModule,
    MatListModule,
    RouterOutlet,
    RouterLinkActive,
    MatToolbarModule,
    MatIconModule,
    MatListItem,
    RouterLink,
    MatButtonModule,
    CommonModule,
    MatCardModule,
    NavComponent
],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  currentLang: Lang = 'it';

  translations = {
    it: {
      materie: [
        { nome: 'Storia', link: '/dash/pagina1' },
        { nome: 'Psicologia', link: '/dash/pagina2' },
        { nome: 'Sociologia', link: '/dash/pagina3' },
        { nome: 'Geografia', link: '/dash/pagina4' },
        { nome: 'Arte', link: '/dash/pagina5' },
        { nome: 'Informatica', link: '/dash/pagina6' },
        { nome: 'Filosofia', link: '/dash/pagina7' },
        { nome: 'Politica', link: '/dash/pagina8' },
        { nome: 'Chimica', link: '/dash/pagina9' },
        { nome: 'Perchè scegliere noi?', link: '/dash/dialog' },
        {nome : 'Quiz', link: '/dash/quiz'}
      ],
      footer1: [
        {nome : "Chi siamo", id:"chisiamo"},
        {nome : "Perché scegliere noi", id:"perche"},
        
      ],

      footer2: [
        {nome:"Contatti", id:"contatti"},
        {nome : "Indirizzo Fisico", id:"indirizzo"},
        {nome : "Numero di telefono", id:"numero"},
        {nome : "Orari di apertura", id:"orario"}
      ]

      // ticket: [
      //   {nome:"Crea Ticket", id:"ticket" }
      // ]
    },
    en: {
      materie: [
        { nome: 'History', link: '/dash/pagina1' },
        { nome: 'Psychology', link: '/dash/pagina2' },
        { nome: 'Sociology', link: '/dash/pagina3' },
        { nome: 'Geography', link: '/dash/pagina4' },
        { nome: 'Art', link: '/dash/pagina5' },
        { nome: 'Computer Science', link: '/dash/pagina6' },
        { nome: 'Philosophy', link: '/dash/pagina7' },
        { nome: 'Politics', link: '/dash/pagina8' },
        { nome: 'Chemistry', link: '/dash/pagina9' },
        { nome: 'Why choose us?', link: '/dash/dialog' },
        {nome: 'Quiz', link: '/dash/quiz'}
      ] ,
     
      footer1 : [
        {nome:"Who are", id: "chisiamo"},
        {nome:"Why choose us?" , id:"perche"},
       
      ],

      footer2: [
        {nome:"Physical Address", id:"indirizzo"},
        {nome:"Number of phone", id:"numero"},
        {nome:"Opening hours", id:"orario"}
      ]
      // ticket: [
      //   {nome:"Create Ticket", id:"ticket"}
      // ]
    }
  };

  constructor(private route: Router) {
    const savedLang = localStorage.getItem('lang');
    if (savedLang === 'it' || savedLang === 'en') {
      this.currentLang = savedLang;
    }
  }

  get materie() {
    return this.translations[this.currentLang].materie;
  }

  get footer1(){
    return this.translations[this.currentLang].footer1
  }

  get footer2(){
    return this.translations[this.currentLang].footer2
  }

  // get ticket(){
  //   return this.translations[this.currentLang].ticket
  // }

  

 

  changeLang(lang: Lang) {
    this.currentLang = lang;
    localStorage.setItem('lang', lang);
  }

  

  onLogout() {
    this.route.navigate(['login']);
  }

  OnProfilo() {
    this.route.navigate(['profilo']);
  }

  onTickets() {
    this.route.navigate(['ticket']);
  }
}
