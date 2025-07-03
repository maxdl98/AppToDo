import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-informazioni',
  imports: [],
  templateUrl: './informazioni.component.html',
  styleUrl: './informazioni.component.css'
})
export class InformazioniComponent implements OnInit {

  nome : string | null = null;
  email : string | null = null;
  provincia : string | null = null;
  

  ngOnInit(): void {
    this.nome = localStorage.getItem('nome')
    this.email = localStorage.getItem('email')
    this.provincia = localStorage.getItem('regione')

    console.log(this.nome)
  }

}
