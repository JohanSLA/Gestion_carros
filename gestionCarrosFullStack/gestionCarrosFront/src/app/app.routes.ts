import { Routes } from '@angular/router';
import { UsuariosListaComponent } from './components/usuarios-lista/usuarios-lista.component';
import { CrearUsuarioComponent } from './components/crear-usuario/crear-usuario.component';
import { LoginUsuarioComponent } from './components/login-usuario/login-usuario.component';
import { HomeUsuarioComponent } from './components/home-usuario/home-usuario.component';
import { AuthGuard } from './guards/auth.guard';

/**
 * Definicion de rutas y componenetes dependiendo la ruta indicada
 */
export const routes: Routes = [
    {path: '', redirectTo: 'login', pathMatch:'full'}, // http:/7loclahost:4200 Redirije al login al iniciar    
    {path:'home', component: HomeUsuarioComponent, canActivate:[AuthGuard]}, //http://localhost:4200/home Para gestion del usuario Nota: esta ruta implementaguardas para proteger la ruta desde el front
    {path:'login',component: LoginUsuarioComponent}, //http://localhost:4200/login para el logue de los usuarios
    //Componente para mostrar lista de usuarios{path:'', component: UsuariosListaComponent}, //http://localhost:4200/
    {path:'agregar/usuario', component: CrearUsuarioComponent} //http://localhost:4200/agregar/usuario para que el usuario se registre
];
