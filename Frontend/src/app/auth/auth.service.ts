// auth.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  constructor(private http: HttpClient) {}

  register(username: string, password: string): Observable<void> {
    return this.http.post<void>('/api/auth/register', { username, password });
  }

  // luego puedes agregar login(), getUserInfo(), etc.
}
