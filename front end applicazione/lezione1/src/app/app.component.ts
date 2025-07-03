import { CommonModule, NgFor, isPlatformBrowser } from '@angular/common'; // Importa isPlatformBrowser
import { Component, HostListener, OnDestroy, OnInit, Inject, PLATFORM_ID } from '@angular/core'; // Importa Inject e PLATFORM_ID
import { RouterLink, RouterOutlet } from '@angular/router';
import { EsercizioComponent } from "./componenti/esercizio/EsercizioComponent";
import { FormsModule } from '@angular/forms';
// import { NgModule } from '@angular/core'; // NgModule non serve qui
import { LoginComponent } from "./componenti/login/login.component";
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NgFor, CommonModule, FormsModule, EsercizioComponent, LoginComponent, MatIconModule, RouterLink, HttpClientModule], // Aggiungi HttpClientModule se non è già nel tuo AppModule
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit, OnDestroy {

  // Inietta PLATFORM_ID nel costruttore
  constructor(private http: HttpClient, @Inject(PLATFORM_ID) private platformId: Object) { }

  private startTime!: number;
  private userId!: number | null;

  ngOnDestroy(): void {
    // La logica di inviaMinutiSpesi qui è più sicura, poiché ngOnDestroy si attiva alla distruzione del componente
    // che nel contesto del browser è quando l'utente lascia la pagina.
    // Tuttavia, HostListener('window:beforeunload') è generalmente più affidabile per la chiusura del tab/finestra.
    // Puoi lasciare entrambi per sicurezza.
  }

  ngOnInit(): void {
    // Controlla se la piattaforma è un browser prima di accedere a localStorage
    if (isPlatformBrowser(this.platformId)) {
      const storedTimestamp = localStorage.getItem('loginTimestamp');
      const storedUserId = localStorage.getItem('userId');

      if (storedTimestamp && storedUserId) {
        this.startTime = parseInt(storedTimestamp, 10);
        this.userId = parseInt(storedUserId, 10);
      }
    }
  }

  @HostListener('window:beforeunload', ['$event'])
  beforeUnloadHandler(event: BeforeUnloadEvent) {
    // Anche qui, potresti voler aggiungere un controllo isPlatformBrowser se questa parte
    // dovesse in qualche modo attivarsi durante l'SSR (meno comune per beforeunload)
    if (isPlatformBrowser(this.platformId)) {
      this.inviaMinutiSpesi(); // Invia i minuti prima che la pagina venga scaricata
    }
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
  mostrare = false; // Meglio inizializzare le proprietà

  change() {
    this.mostrare = !this.mostrare;
  }
}