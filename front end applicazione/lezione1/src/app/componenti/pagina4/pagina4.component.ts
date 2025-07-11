import { Component } from '@angular/core';
import { Pagina1Component } from "../pagina1/pagina1.component";
import { MatCardModule, MatCardTitle } from '@angular/material/card';

@Component({
  selector: 'app-pagina4',
  imports: [Pagina1Component,MatCardModule,MatCardTitle],
  templateUrl: './pagina4.component.html',
  styleUrl: './pagina4.component.css'
})
export class Pagina4Component {

}
