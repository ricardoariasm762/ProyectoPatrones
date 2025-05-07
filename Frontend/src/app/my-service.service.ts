import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyService {
  constructor(private http: HttpClient) {}

  ping(): Observable<any> {
    return this.http.get('http://localhost:8001/pong'); // Ajusta la URL
  }
}
