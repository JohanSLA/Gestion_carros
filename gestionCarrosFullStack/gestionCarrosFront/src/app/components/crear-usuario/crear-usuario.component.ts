import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../usuario';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../service/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-usuario',
  imports: [FormsModule],
  templateUrl: './crear-usuario.component.html',
  styleUrl: './crear-usuario.component.css',
})
export class CrearUsuarioComponent implements OnInit {
  id: string = '';
  nombre: string = '';
  apellido: string = '';
  email: string = '';
  password: string = '';

  constructor(private usuarioService: UsuarioService, private router: Router) {}

  ngOnInit(): void {}

  /**
   * Metodo que permite asociar los datos de la plantilla html al componenete para guardar un usuario
   */
  agregarUsuario() {
    let usuario = new Usuario(
      this.id,
      this.nombre,
      this.apellido,
      this.email,
      this.password
    );
    console.log(usuario); //para ver los datos del usuario por consola (-------No olvidar borrar----)

    this.usuarioService.agregarUsuario(usuario).subscribe(
      (res) => {
        console.log(res);
        alert('Usuario creado exitosamente con el id: ' + this.id);
        this.router.navigate(['/login']);
      },
      (err: any) => {
        console.error(err);
        alert('Ocurrió un error al crear el usuario, porfavor verifica que introdujeras todos tus datos y que no tengas una cuenta con nosotros.');
      }
    );
  }

  /**
   * Metodo para volver al loguin si asi se desea
   */
  irLogin() {
    this.router.navigate(['/login']);
  }
}

