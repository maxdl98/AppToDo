import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { AuthserviceService, Page } from '../../auth/authservice.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule, PageEvent } from '@angular/material/paginator';
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
export class TicketchiusiComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['libriDisponibili', 'nome', 'risposta'];
  dataSource = new MatTableDataSource<any>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  totalElements = 0;
  pageSize = 5;
  pageSizeOptions = [5,10,25,100]

  constructor(private service: AuthserviceService) {}


  ngAfterViewInit(): void {
    this.paginator.page.subscribe((evt:PageEvent) =>{
  this.loadPage(evt.pageIndex, evt.pageSize)
    })
  }


  // se io cambio la paginazione, faccio la chiamata con la nuova paginazione, se ne chiedo 5, me ne restituisce 5 
  ngOnInit(): void {
    this.loadPage(0,this.pageSize)
  }

  

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }




 private loadPage(page:number,size:number):void{
    console.log(`→ loadPage chiamato con pageIndex=${page}, pageSize=${size}`);

     this.service.getFormatori(page,size)
     .subscribe((paginated:Page<any>) =>{
      this.dataSource.data = paginated.content;
      this.totalElements = paginated.totalElements;
      this.pageSize = paginated.size;
      console.log('→ loadPage invoked with', page, size);

     })
  }
}
