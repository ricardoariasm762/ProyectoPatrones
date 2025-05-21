import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component'; // 👈 Standalone
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { RetosComponent } from './components/retos/retos.component';

import { routes } from './app.routes';

@NgModule({
  // ❌ Ya no se usan con standalone components
  declarations: [],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),

    // ✅ IMPORTAMOS los componentes standalone
    AppComponent,
    RegisterComponent,
    LoginComponent,
    PerfilComponent,
    RetosComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

