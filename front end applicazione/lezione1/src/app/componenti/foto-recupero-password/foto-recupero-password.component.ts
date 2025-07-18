import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-foto-recupero-password',
  imports: [CommonModule],
  templateUrl: './foto-recupero-password.component.html',
  styleUrl: './foto-recupero-password.component.css'
})
export class FotoRecuperoPasswordComponent {


  constructor(){}

  loginBackground : boolean = true;
}
