import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class WorkersService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAll(): Observable<Worker[]> {
    return this.http.get<any>(`http://localhost:8080/workers`);
  }

  public getPdfPrint(): Observable<BlobPart> {
    return this.http.get<any>(`http://localhost:8080/workers/print_pdf`, {responseType: 'arraybuffer'as'json'});
  }

}

