import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Noticias } from './noticias';

@Injectable({
  providedIn: 'root',
})
export class NoticiasService {
  private urlEndPoint: string = 'http://localhost:8080/api/noticias';
  constructor(private http: HttpClient) {}

  getIndice(): Observable<Noticias[]> {
    return this.http.get<Noticias[]>(this.urlEndPoint);
  }
  getExpiredNews(): Observable<Noticias[]> {
    return this.http.get<Noticias[]>(this.urlEndPoint+'/expired');
  }
}