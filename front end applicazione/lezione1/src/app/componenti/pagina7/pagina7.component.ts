import { Component } from '@angular/core';
import { Pagina1Component } from "../pagina1/pagina1.component";
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-pagina7',
  imports: [Pagina1Component,MatCardModule],
  templateUrl: './pagina7.component.html',
  styleUrl: './pagina7.component.css'
})
export class Pagina7Component {

}
