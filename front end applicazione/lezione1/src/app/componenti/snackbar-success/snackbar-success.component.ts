import { Component, Inject } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MAT_SNACK_BAR_DATA } from '@angular/material/snack-bar';

@Component({
  selector: 'app-snackbar-success',
  imports: [MatIconModule],
  templateUrl: './snackbar-success.component.html',
  styleUrl: './snackbar-success.component.css'
})
export class SnackbarSuccessComponent {
  constructor(@Inject(MAT_SNACK_BAR_DATA)public data: string){}

}
