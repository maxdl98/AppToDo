import { Component, ViewEncapsulation } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';


@Component({
  selector: 'app-pagina1',
  imports: [MatCardModule,MatToolbarModule,MatIconModule],
  templateUrl: './pagina1.component.html',
  styleUrl: './pagina1.component.css',
  encapsulation: ViewEncapsulation.None
})
export class Pagina1Component {

}
