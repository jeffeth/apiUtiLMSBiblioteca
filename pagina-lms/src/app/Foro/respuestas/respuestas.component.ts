import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Quill from 'quill';
import Swal from 'sweetalert2';
import { Foro } from '../foro';
import { EmpRolUser } from './emp-rol-user';
import { Respuestas } from './respuestas';
import { RespuestasService } from './respuestas.service';

@Component({
  selector: 'app-respuestas',
  templateUrl: './respuestas.component.html',
  styleUrls: ['./respuestas.component.scss'],
})
export class RespuestasComponent implements OnInit {
  quill: any = {};
  id: any;
  respuestas!: Respuestas[];
  foro: any = [];
  getForo!: Respuestas[];
  respuesta: Respuestas = new Respuestas();
  page: number = 1;
  idAux: String = '';
  emisor: String = "";

  constructor(
    private apiService: RespuestasService,
    private activatedRouter: ActivatedRoute,
    private router: Router,
    private location: Location,
  ) {}

  ngOnInit(): void {
    this.cargarRespuesta();

    var toolbarOptions = [
      ['bold', 'italic', 'underline', 'strike'], // toggled buttons
      ['code-block'],

      [{ list: 'ordered' }, { list: 'bullet' }],
      [{ script: 'sub' }, { script: 'super' }], // superscript/subscript
      [{ indent: '-1' }, { indent: '+1' }], // outdent/indent

      [{ size: ['small', false, 'large', 'huge'] }], // custom dropdown

      [{ color: [] }, { background: [] }], // dropdown with defaults from theme
      [{ font: [] }],
      [{ align: [] }],

      ['clean'], // remove formatting button
    ];

    this.quill = new Quill('#editor', {
      modules: {
        toolbar: toolbarOptions,
      },
      theme: 'snow',
    });
  }

  cargarRespuesta() {
    this.activatedRouter.params.subscribe((params) => {
      try {
        this.id = atob(params['id'] || '');
        this.idAux = this.router.url.slice(18, -2);
      } catch (error) {}
      this.page = params['page'];
      if (this.id) {
        this.apiService
          .getRespuestas(this.id)
          .subscribe((api) => (this.respuestas = api));
        this.apiService
          .getForo(this.id)
          .subscribe(
            (apiforo) => (this.notNull(apiforo), (this.getForo = apiforo))
          );
      }
    });
  }

  notNull(apiForo) {
    if (apiForo) {
      this.foro = Array.of(apiForo);
    } else {
      this.foro = new Foro();
    }
  }

  return() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.navigate(['/foros', this.page]);
    //this.location.back();
  }

  public create(): void {
    let currentUrl = this.router.url;
    this.router.routeReuseStrategy.shouldReuseRoute = () => true;
    this.router.onSameUrlNavigation = 'reload';

    var html = this.quill.root.innerHTML;
    const decodedHtml = html.replace(/&lt;/g, '<').replace(/&gt;/g, '>');
    this.respuesta.respuesta = decodedHtml;
    this.respuesta.foro = this.getForo;
    this.respuesta.empRolUser = new EmpRolUser(); //para mientras
    this.emisor = "Josué Cornejo"; //usuarioService.usuario.nombre
    if (this.respuesta.respuesta == '<p><br></p>') {
      Swal.fire(
        '¡Necesita agregar una respuesta!',
        'Todos los campos son obligatorios',
        'error'
      );
    } else {
      this.apiService.create(this.respuesta).subscribe((response) => {
        this.router.navigate([currentUrl]),
          this.apiService.sendMail(this.respuesta, this.emisor ,this.idAux, html).subscribe();
      });
      Swal.fire(
        'Respuesta agregada',
        `¡Respuesta agregada con éxito!`,
        'success'
      );
      this.quill.root.innerHTML = '';
    }
  }

  delete(id: number) {
    let currentUrl = this.router.url;
    this.router.routeReuseStrategy.shouldReuseRoute = () => true;
    this.router.onSameUrlNavigation = 'reload';
    Swal.fire({
      title: '¿Está seguro?',
      text: '¡No podrá revertir la acción!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: '¡Si, eliminar!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.apiService.delete(id).subscribe((response) => {
          Swal.fire('¡Eliminado!', 'La respuesta fué eliminada.', 'success');
          this.router.navigate([currentUrl]);
        });
      }
    });
  }
}
