import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Noticias } from '../noticias';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class VerNoticiaService {
  arrayNotice: any = [];
  private urlEndPoint: string = 'http://localhost:8080/api/noticias';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) {}

  getIndice(id: any): Observable<Noticias[]> {
    this.arrayNotice = [];
    return this.http.get<Noticias[]>(`${this.urlEndPoint}/${id}`).pipe(
      map((response) => {
        let data = response as Noticias[];
          this.arrayNotice.push(data);
        return this.arrayNotice;
      })
    );
  }

  getNotice(): Observable<Noticias[]> {
    return this.http
      .get(this.urlEndPoint)
      .pipe(map((response) => response as Noticias[]));
  }

  delete(id: number): Observable<Noticias> {
    return this.http.delete<Noticias>(`${this.urlEndPoint}/${id}`, {
      headers: this.httpHeaders,
    });
  }
}
