import { Routes } from '@angular/router';
import { UsuariosListaComponent } from './components/usuarios-lista/usuarios-lista.component';
import { CrearUsuarioComponent } from './components/crear-usuario/crear-usuario.component';

/**
 * Definicion de rutas y componenetes dependiendo la ruta indicada por el navegador
 */
export const routes: Routes = [
    {path:'', component: UsuariosListaComponent}, //http://localhost:4200/
    {path:'agregar/usuario', component: CrearUsuarioComponent} //http:/7localhost:4200/agregar/usuario
];
