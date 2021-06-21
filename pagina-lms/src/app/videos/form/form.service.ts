import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contenido } from '../contenido/contenido';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private urlEndPoint: string = 'http://localhost:8080/api/videos';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) {}

  create(video: Contenido): Observable<Contenido> {
    return this.http.post<Contenido>(this.urlEndPoint, video, {
      headers: this.httpHeaders,
    });
  }

  getVideo(id: number): Observable<Contenido> {
    return this.http.get<Contenido>(`${this.urlEndPoint}/${id}`);
  }

  update(cont: Contenido): Observable<Contenido> {
    return this.http.put<Contenido>(
      `${this.urlEndPoint}/${cont.id}`,
      cont,
      { headers: this.httpHeaders }
    );
  }
}
