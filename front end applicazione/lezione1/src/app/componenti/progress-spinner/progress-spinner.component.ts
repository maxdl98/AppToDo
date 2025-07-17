import { Component, Inject, PLATFORM_ID } from '@angular/core';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { MatNoDataRow } from "@angular/material/table";
import { FotologinAdminComponent } from '../fotologin-admin/fotologin-admin.component';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-progress-spinner',
  imports: [MatProgressSpinnerModule,FotologinAdminComponent],
  standalone : true,
  templateUrl: './progress-spinner.component.html',
  styleUrl: './progress-spinner.component.css'
})
export class ProgressSpinnerComponent {
isBrowser: boolean;

  constructor(@Inject(PLATFORM_ID) platformId: Object) {
    this.isBrowser = isPlatformBrowser(platformId);
  }
}
