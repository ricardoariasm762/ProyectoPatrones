import { Component } from '@angular/core';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent {
  usuario = {
    nombre: 'Cristian',
    correo: 'cristian@email.com',
    nivel: 'Intermedio',
    puntos: 750,
    logros: ['Primer reto resuelto', '5 días consecutivos', 'Perfil completado']
  };
}
