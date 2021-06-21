import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EmptyError, Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Contenido } from './contenido';

@Injectable({
  providedIn: 'root',
})
export class ContenidoService {
  id: any;
  ContentbyId: any = [];

  constructor(private http: HttpClient) {}

  private urlEndPoint: string = 'http://localhost:8080/api/videos';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getIndice(id: any): Observable<Contenido[]> {
    // return this.http.get<Contenido[]>(this.urlEndPoint);
    this.ContentbyId = [];
    return this.http.get<Contenido[]>(this.urlEndPoint).pipe(
      map((response) => {
        let videos = response as Contenido[];
        for (const data of videos) {
          if (data.indice_video.id == id) {
            this.ContentbyId.push(data);
          }
        }
        return this.ContentbyId;
      })
    );
  }

  delete(id: number): Observable<Contenido> {
    return this.http.delete<Contenido>(`${this.urlEndPoint}/${id}`, {
      headers: this.httpHeaders,
    });
  }
}
