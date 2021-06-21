import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgsRevealConfig } from 'ngx-scrollreveal';
import { Noticias } from './noticias';
import { NoticiasService } from './noticias.service';
import { UsuarioService } from '../login/usuario.service';

@Component({
  selector: 'app-noticias',
  templateUrl: './noticias.component.html',
  styleUrls: ['./noticias.component.scss'],
  providers: [NgsRevealConfig],
})
export class NoticiasComponent implements OnInit {
  data!: Noticias[];
  page: any;
  collection: any[] = this.data;

  constructor(
    private _router: Router,
    private apiService: NoticiasService,
    private activatedRoute: ActivatedRoute,
    config: NgsRevealConfig,
    public usuarioService: UsuarioService
  ) {
    // customize default values of ngx-scrollreveal directives used by this component tree
    config.duration = 5000;
    config.easing = 'cubic-bezier(0.645, 0.045, 0.355, 1)';
  }

  session = { active: 'active' };
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((params) => {
      if (params.get('page')) {
        this.page = params.get('page');
      } else {
        this.page = 1;
      }
      this.apiService.getIndice().subscribe(
        (api) => (
          (this.data = api.reverse())
        )
      );
    });
  }

  // Convertimos el parametro de url a base 64
  showNotice(id: any, page: number) {
    this._router.navigate(['/noticia', btoa(id), page]);
  }
}
