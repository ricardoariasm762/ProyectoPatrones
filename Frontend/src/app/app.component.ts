import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterModule], // 👈 IMPORTANTE
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private http: HttpClient) {}

  ping() {
    this.http.get('/api/ping', { responseType: 'text' }).subscribe({
      next: (res) => console.log('✅ Respuesta del backend:', res),
      error: (err) => console.error('❌ Error:', err)
    });
  }
}
