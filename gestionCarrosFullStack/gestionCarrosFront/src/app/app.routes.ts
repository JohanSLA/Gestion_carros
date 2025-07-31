import { Routes } from '@angular/router';
import { UsuariosListaComponent } from './components/usuarios-lista/usuarios-lista.component';
import { CrearUsuarioComponent } from './components/crear-usuario/crear-usuario.component';
import { LoginUsuarioComponent } from './components/login-usuario/login-usuario.component';

/**
 * Definicion de rutas y componenetes dependiendo la ruta indicada por el navegador
 */
export const routes: Routes = [
    {path:'login',component: LoginUsuarioComponent}, //http://localhost:4200/login
    {path:'', component: UsuariosListaComponent}, //http://localhost:4200/ (para mostrar la)
    {path:'agregar/usuario', component: CrearUsuarioComponent} //http://localhost:4200/agregar/usuario
];
