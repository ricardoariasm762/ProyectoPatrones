import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AuthService } from '../../auth/auth.service'; // Ajusta el path si lo cambiaste

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  form = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private authService: AuthService) {}

  onSubmit() {
    const { username, password } = this.form.value;
    if (username && password) {
      this.authService.register(username, password).subscribe({
        next: () => alert('✅ Usuario registrado'),
        error: err => alert('❌ Error: ' + (err.error?.message || 'Registro fallido'))
      });
    }
  }
}

