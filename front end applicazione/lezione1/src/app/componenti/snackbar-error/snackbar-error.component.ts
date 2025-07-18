import { Component, Inject } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MAT_SNACK_BAR_DATA } from '@angular/material/snack-bar';

@Component({
  selector: 'app-snackbar-error',
  imports: [MatIconModule],
  templateUrl: './snackbar-error.component.html',
  styleUrl: './snackbar-error.component.css'
})
export class SnackbarErrorComponent {



  constructor(@Inject(MAT_SNACK_BAR_DATA)public data:string){

  }

}
