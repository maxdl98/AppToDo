import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatFormField } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-fotologin',
  imports: [ CommonModule, MatFormField, ReactiveFormsModule],
  templateUrl: './fotologin.component.html',
  styleUrl: './fotologin.component.css'
})
export class FotologinComponent {


  constructor(){}

  loginBackground: boolean = true;

}
