import {Component, ViewChild} from '@angular/core';
import {WorkersService} from "./Service/workers.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {catchError, EMPTY, tap} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent {
  title = 'Front';

  dataWorkers = new MatTableDataSource();
  displayedColumns = ['name', 'surname' ];

  @ViewChild(MatSort, {static: true}) sort!: MatSort;

  constructor(private workersService: WorkersService) {
    this.workersService.getAll().pipe(
      tap( (workers)=>{
        this.dataWorkers.data = workers;
        this.dataWorkers.sort = this.sort;
      }),
      catchError( ()=>{
          console.log("Ups..problem")
          return EMPTY;
      })
    ).subscribe()
  }

  printPdf(): void{
    this.workersService.getPdfPrint().pipe(
      tap( (byteResult)=>{
        const blob: any = new Blob( [byteResult], {type: 'application/pdf'})
        const url =window.URL.createObjectURL(blob);
        window.open(url);
      }),
      catchError( ()=>{
        console.log("Ups.. problem with PDF print")
        return EMPTY;
      })
    ).subscribe()

  }

}
