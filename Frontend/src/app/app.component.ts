import { Component, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h1>App Angular + Spring Boot</h1>
    <button (click)="ping()">Probar API</button>
  `
})
export class AppComponent {
  private http = inject(HttpClient);

  ping() {
    this.http.get('/api/ping', { responseType: 'text' }).subscribe({
      next: (res) => console.log('✅ Respuesta del backend:', res),
      error: (err) => console.error('❌ Error:', err)
    });
  }
}
