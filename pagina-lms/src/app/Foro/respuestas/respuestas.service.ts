import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Foro } from '../foro';
import { Respuestas } from './respuestas';

@Injectable({
  providedIn: 'root',
})
export class RespuestasService {
  arrayRespts: any = [];
  private urlEndPoint: string = 'http://localhost:8080/api/respuestas';
  private urlEndPointForo: string = 'http://localhost:8080/api/foros';
  private urlEndPointMail: string =
    'http://localhost:8080/notification/respuesta';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) {}

  getRespuestas(id: number): Observable<Respuestas[]> {
    this.arrayRespts = [];
    return this.http.get<Respuestas[]>(`${this.urlEndPoint}/${id}`).pipe(
      map((response) => {
        let data = response as Respuestas[];
        for (const iterator of data) {
          this.arrayRespts.push(data);
        }
        return this.arrayRespts;
      })
    );
  }
  getForo(id: number): Observable<Respuestas[]> {
    this.arrayRespts = [];
    return this.http.get<Respuestas[]>(`${this.urlEndPointForo}/${id}`).pipe(
      catchError(this.handleError) // then handle the error
    );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, ` + `body was: ${error.error}`
      );
    }
    // Return an observable with a user-facing error message.
    return throwError('Something bad happened; please try again later.');
  }

  create(resp: Respuestas): Observable<Respuestas> {
    return this.http.post<Respuestas>(this.urlEndPoint, resp, {
      headers: this.httpHeaders,
    });
  }

  delete(id: number): Observable<Respuestas> {
    return this.http.delete<Respuestas>(`${this.urlEndPoint}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  sendMail(
    respuesta: Respuestas,
    emisor: String,
    urlForo: String,
    html: any
  ): Observable<Foro> {
    return this.http.get<Foro>(
      `${this.urlEndPointMail}/${emisor}/${urlForo}/${
        respuesta.foro.tema
      }/${btoa(
        html
      )}`,
      {
        headers: this.httpHeaders,
      }
    );
  }
}
