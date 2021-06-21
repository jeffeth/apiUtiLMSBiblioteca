import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../login/usuario.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(public usuarioService: UsuarioService, private router: Router) {}
  logout(): void {
    this.usuarioService.logout();
    this.router.navigate(['/login']);
  }
  ngOnInit(): void {}
}
