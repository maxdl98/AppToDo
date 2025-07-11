import { Component } from '@angular/core';
import { TabellaGenericaComponent } from "../tabella-generica/tabella-generica.component";
import { Pagina1Component } from "../pagina1/pagina1.component";
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-pagina9',
  imports: [TabellaGenericaComponent, Pagina1Component,MatCardModule],
  templateUrl: './pagina9.component.html',
  styleUrl: './pagina9.component.css'
})
export class Pagina9Component {

}
