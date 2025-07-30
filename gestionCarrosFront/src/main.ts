import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { EjemploComponent } from './app/ejemplo/ejemplo.component';
import { UsuariosListaComponent } from './app/components/usuarios-lista/usuarios-lista.component';
import { provideHttpClient } from '@angular/common/http';
import { CrearUsuarioComponent } from './app/components/crear-usuario/crear-usuario.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
