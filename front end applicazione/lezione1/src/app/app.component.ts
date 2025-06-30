import { CommonModule, NgFor } from '@angular/common';
import { Component, HostListener, OnDestroy, OnInit } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { EsercizioComponent } from "./componenti/esercizio/EsercizioComponent";
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { LoginComponent } from "./componenti/login/login.component";
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NgFor, CommonModule, FormsModule, EsercizioComponent, LoginComponent,MatIconModule,RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit,OnDestroy  {

  constructor(private http:HttpClient){}

  private startTime!: number;
  private userId!: number | null;

  ngOnDestroy(): void {
 

  }
  ngOnInit(): void {
   const storedTimestamp = localStorage.getItem('loginTimestamp');
    const storedUserId = localStorage.getItem('userId');

if (storedTimestamp && storedUserId) {
      this.startTime = parseInt(storedTimestamp, 10);
      this.userId = parseInt(storedUserId, 10);
    }
  }

   @HostListener('window:beforeunload', ['$event'])
  beforeUnloadHandler(event: BeforeUnloadEvent) {
    this.inviaMinutiSpesi(); // Invia i minuti prima che la pagina venga scaricata
  }


   private inviaMinutiSpesi(): void {
    if (this.startTime && this.userId) {
      const endTime = Date.now(); // Timestamp attuale al momento della chiusura/logout
      const tempoTrascorsoMs = endTime - this.startTime; // Tempo in millisecondi
      const minutiSpesi = Math.round(tempoTrascorsoMs / 60000); // Converti in minuti (1 minuto = 60000 ms)

      if (minutiSpesi > 0) {
        const payload = {
          minuti: minutiSpesi,
          dataLogin: new Date().toISOString().split('T')[0] 
        };

        // Effettua la chiamata POST al tuo backend
        this.http.post(`http://localhost:8080/api/minutisesi/registra/${this.userId}`, payload).subscribe({
          next: (response) => console.log('Minuti spesi registrati con successo!', response),
          error: (error) => console.error('Errore durante la registrazione dei minuti:', error)
        });
      }
    }
  }








  title = 'lezione1';

  mostrare = false






  change(){
    this.mostrare = !this.mostrare
  }

  


 



  
 


}
