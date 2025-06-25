import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { Pagina1Component } from '../pagina1/pagina1.component';

@Component({
  selector: 'app-pagina3',
  imports: [MatCardModule,Pagina1Component],
  templateUrl: './pagina3.component.html',
  styleUrl: './pagina3.component.css'
})
export class Pagina3Component {

}
