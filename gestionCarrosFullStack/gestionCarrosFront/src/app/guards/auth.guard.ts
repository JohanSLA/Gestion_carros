import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

/**
 * Esto nos servira pra proteger las rutas, lo que es revisar si hay un token en el localstorage, en caso de no encontrarlo redirije a la ruta para que se loguee el usuario
 */

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(): boolean {
    const token = localStorage.getItem('token');
    if (token) {
      return true;
    } else {
      alert("No tienes permiso para ingresar a esta ruta!!!")
      this.router.navigate(['/login']);
      return false;
    }
  }
}