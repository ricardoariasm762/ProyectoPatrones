import { Component } from '@angular/core';

@Component({
  selector: 'app-retos',
  templateUrl: './retos.component.html',
  styleUrls: ['./retos.component.css']
})
export class RetosComponent {
  retos = [
    { titulo: 'Suma de números', dificultad: 'Fácil', descripcion: 'Escribe una función que sume dos números.' },
    { titulo: 'Palíndromo', dificultad: 'Media', descripcion: 'Verifica si una palabra es un palíndromo.' },
    { titulo: 'Ordenar lista', dificultad: 'Difícil', descripcion: 'Ordena una lista de forma ascendente sin usar sort().' },
  ];
}
