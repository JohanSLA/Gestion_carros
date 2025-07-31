import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../usuario';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../service/usuario.service';

@Component({
  selector: 'app-crear-usuario',
  imports: [FormsModule],
  templateUrl: './crear-usuario.component.html',
  styleUrl: './crear-usuario.component.css'
})
export class CrearUsuarioComponent implements OnInit {

  id: string = '';
  nombre: string = '';
  apellido: string = '';
  email: string = '';
  password: string = '';


  constructor(private usuarioService : UsuarioService){

  }

  ngOnInit(): void {
  }

  /**
   * Metodo que permite asociar los datos de la plantilla html al componenete para guardar un usuario
   */
  agregarUsuario(){
    let usuario = new Usuario(this.id, this.nombre, this.apellido, this.email, this.password);
    console.log(usuario); //para ver los datos del usuario por consola (-------No olvidar borrar----)

    this.usuarioService.agregarUsuario(usuario).subscribe(
      res => console.log(res)
    );
  }

}
