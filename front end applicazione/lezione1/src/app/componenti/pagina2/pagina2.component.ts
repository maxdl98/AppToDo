import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { Pagina1Component } from "../pagina1/pagina1.component";

@Component({
  selector: 'app-pagina2',
  imports: [MatCardModule, Pagina1Component],
  templateUrl: './pagina2.component.html',
  styleUrl: './pagina2.component.css'
})
export class Pagina2Component {

}
