import { Component } from '@angular/core';
import { Pagina1Component } from "../pagina1/pagina1.component";
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-pagina5',
  imports: [Pagina1Component,MatCardModule],
  templateUrl: './pagina5.component.html',
  styleUrl: './pagina5.component.css'
})
export class Pagina5Component {

}
