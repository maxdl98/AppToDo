import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { Router } from '@angular/router';
import { AuthserviceService } from '../../auth/authservice.service';

@Component({
  selector: 'app-nav',
  imports: [MatIconModule,CommonModule],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {
  urlExcel = "http://localhost:8080/api/tickets/exportExcel"
  urlPdf = "http://localhost:8080/api/tickets/exportPdf"
 
  
 constructor(private route:Router, private service:AuthserviceService) {
  
 }


  onLogout(){
    this.route.navigate(['loginAdmin'])
  }

 downloadExcel() {
  this.service.downloadExcel(this.urlExcel).subscribe({
    next: (blob: Blob) => {
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = 'segnalazioni.xlsx';
      a.click();
      window.URL.revokeObjectURL(url); // buona pratica
    },
    error: (err) => {
      console.error('Errore nel download Excel:', err);
    }
  });
}

downloadPdf() {
  this.service.downloadPdf(this.urlPdf).subscribe({
    next: (blob:Blob) => {
   const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'tickets.pdf'; // nome del file
    a.click();
    window.URL.revokeObjectURL(url);
    },
    error: (err) =>{
      console.error("errore nel download del pdf", err);
    }
  });
}






}
