import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { TabellaGenericaComponent } from '../tabella-generica/tabella-generica.component';
import { CommonModule } from '@angular/common';
import { TabellaComponent } from '../tabella/tabella.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dialog',
  standalone: true,
  imports: [CommonModule, MatButtonModule, MatDialogModule, TabellaGenericaComponent, TabellaComponent],
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css'], // <== CORRETTO qui
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class DialogComponent  {
  public showForm = false;

  constructor() {}

  

  openForm() {
    this.showForm = true;
  }
}
