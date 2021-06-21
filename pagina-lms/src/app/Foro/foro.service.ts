import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Foro } from './foro';
import { catchError } from 'rxjs/operators';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class ForoService {
  private urlEndPoint: string = 'http://localhost:8080/api/foros';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {}

  getForos(): Observable<Foro[]> {
    return this.http.get<Foro[]>(this.urlEndPoint);
  }

  delete(id: number): Observable<Foro> {
    return this.http.delete<Foro>(`${this.urlEndPoint}/${id}`, {
      headers: this.httpHeaders
    }).pipe(
      catchError(err => {
        Swal.fire('¡FORO NO ELIMINADO!', 'El foro está activo, asegúrese que este no contenga respuestas.', 'error');
        return throwError(err);
    })
    );
  }
}
