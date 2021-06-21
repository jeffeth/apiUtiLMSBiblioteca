import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Quill from 'quill';
import Swal from 'sweetalert2';
import { Foro } from '../foro';
import { NuevoForoService } from './nuevo-foro.service';
@Component({
  selector: 'app-nuevo-foro',
  templateUrl: './nuevo-foro.component.html',
  styleUrls: ['./nuevo-foro.component.css'],
})
export class NuevoForoComponent implements OnInit, AfterViewInit {
  quill: any = {};
  foro: Foro = new Foro();
  @ViewChild('content', { static: false }) contenidoDelModal;
  ngAfterViewInit() {
    this.openLg();
  }

  constructor(
    private modalService: NgbModal,
    private router: Router,
    private apiService: NuevoForoService
  ) {}

  openLg() {
    this.modalService.open(this.contenidoDelModal, {
      size: 'lg',
      centered: true,
    });

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

  ngOnInit(): void {}

  public create(): void {
    let currentUrl = this.router.url;
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';

    var html = this.quill.root.innerHTML;
    const decodedHtml = html.replace(/&lt;/g, '<').replace(/&gt;/g, '>');
    this.foro.contenido = decodedHtml;
    this.foro.createAt = new Date();
    this.foro.createBy = 'nombre usuario';
    if (this.foro.tema == '' || this.foro.contenido == '<p><br></p>') {
      Swal.fire('Campos vacios', `Todos los campos son obligatorios`, 'error');
    } else {
      this.apiService.create(this.foro).subscribe((response) => {
        this.router.navigate(['/foros']),
          this.apiService.sendMail(this.foro.tema, this.foro.createBy).subscribe();
      });
      Swal.fire('Foro agregado', `!El foro fué agregado con éxito!`, 'success');
    }
  }
}
