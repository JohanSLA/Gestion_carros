import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LoginService } from '../../service/login.service';
import { Login } from '../../login';
import { Router} from '@angular/router';

@Component({
  selector: 'app-login-usuario',
  imports: [FormsModule],
  templateUrl: './login-usuario.component.html',
  styleUrl: './login-usuario.component.css'
})
export class LoginUsuarioComponent {

  email: string = '';
  password: string= '';


  constructor(private loginService : LoginService,
              private router: Router
  ){}

  ngOnInit(): void {
  }

  loguearUsuario(){
    let login = new Login(this.email, this.password);
    console.log('Se esta intentando loguear'+login.email) //muetsra quien esta intentando loguearse por consola

    this.loginService.loguearUsuario(login).subscribe(
      (res: any) => {
      console.log('Token recibido:', res.token);  //imprimimos el formato json que devuelve

      // Guarda el token y el id en localStorage
      localStorage.setItem('token', res.token);
      localStorage.setItem('usuario', JSON.stringify(res.usuario)); 

      // Redirige al home o cualquier ruta
      this.router.navigate(['/home']);
    },
    err => {
      console.error('Error al loguear', err);
      alert("Ocurrio un error al inicar, porfavor verifica tus datos e intenta nuevamente.")
    }
    );
  }


  /**
   * Metodo que se ejecuta al apretar el boton para ir al login
   */
  irLogin(){
    this.router.navigate(['/agregar/usuario']);
  }
}
