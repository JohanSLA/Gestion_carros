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
    console.log('Se esta intentando loguear'+login.email) //Prueba para ver los datos del login (-------No olvidar borrar-----)

    this.loginService.loguearUsuario(login).subscribe(
      (res: any) => {
      console.log('Token recibido:', res.token);  // ✅ Ahora reconoce res.token

      // Guarda el token en localStorage
      localStorage.setItem('token', res.token);

      // Redirige al home o cualquier ruta
      this.router.navigate(['/']);
    },
    err => {
      console.error('Error al loguear', err);
    }
    );
  }
}
