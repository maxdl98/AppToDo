import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { AuthserviceService } from '../../auth/authservice.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatFormField, MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-ticketchiusi',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule,MatInputModule,MatFormFieldModule,MatSortModule],
  templateUrl: './ticketchiusi.component.html',
  styleUrl: './ticketchiusi.component.css'
})
export class TicketchiusiComponent implements OnInit {
  displayedColumns: string[] = ['libriDisponibili', 'nome', 'risposta'];
  dataSource = new MatTableDataSource<any>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private service: AuthserviceService) {}


  // se io cambio la paginazione, faccio la chiamata con la nuova paginazione, se ne chiedo 5, me ne restituisce 5 
  ngOnInit(): void {
    this.service.getFormatori().subscribe(data => {
      this.dataSource.data = data as any[];
 this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
      this.dataSource.filterPredicate = (data: any, filter: string) => {
  const dataStr = (data.nome + data.risposta + data.libriDisponibili).toLowerCase();
  return dataStr.includes(filter);
};
    });
  }

  

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
