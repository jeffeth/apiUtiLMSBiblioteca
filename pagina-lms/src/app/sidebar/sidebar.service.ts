import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sidebar } from './sidebar';

@Injectable({
  providedIn: 'root',
})
export class SidebarService {
  private urlEndPoint: string = 'http://localhost:8080/api/indice_video';
  constructor(private http: HttpClient) {}

  getIndice(): Observable<Sidebar[]> {
    return this.http.get<Sidebar[]>(this.urlEndPoint);
  }
}
