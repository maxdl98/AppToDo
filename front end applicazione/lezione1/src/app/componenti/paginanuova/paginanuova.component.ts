import { Component } from '@angular/core';
import { TabellaComponent } from '../tabella/tabella.component';
import { MatTable, MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-paginanuova',
  imports: [TabellaComponent,MatTableModule],
  templateUrl: './paginanuova.component.html',
  styleUrl: './paginanuova.component.css'
})
export class PaginanuovaComponent {

}
