import { Component, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { AuthserviceService, Page } from '../../auth/authservice.service';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatFormFieldControl, MatFormFieldModule,MatFormField } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-ticketchiusi2',
  imports: [MatPaginator,MatFormFieldModule,MatTableModule,MatInputModule],
  templateUrl: './ticketchiusi2.component.html',
  styleUrl: './ticketchiusi2.component.css'
})
export class Ticketchiusi2Component {

  displayedColumns: string[] = ['libriDisponibili', 'nome', 'risposta'];
  dataSource = new MatTableDataSource<any>();


  @ViewChild(MatPaginator) paginator!:MatPaginator
  @ViewChild(MatSort) sort!:MatSort






  totalElements = 0;
  pageSize = 5;
  pageSizeOptions = [5,10,25,100]




  constructor(private service:AuthserviceService){

  }


  ngAfterViewInit():void{
   this.paginator.page.subscribe((evt:PageEvent) =>{
    this.loadPage(evt.pageIndex, evt.pageSize)
   })
  }


  ngOnInit() : void {
    this.loadPage(0,this.pageSize)
  }





   applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  private loadPage(page:number, size:number){

    this.service.getFormatori(page,size)
    .subscribe((paginated:Page<any>) => {
      this.dataSource.data = paginated.content
      this.totalElements = paginated.totalElements
      this.pageSize = paginated.size
    })
  }








}
