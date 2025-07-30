import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../usuario';
import { UsuarioService } from '../../service/usuario.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuarios-lista',
  imports: [CommonModule],
  templateUrl: './usuarios-lista.component.html',
  styleUrl: './usuarios-lista.component.css'
})
export class UsuariosListaComponent implements OnInit {
  
  usuarios : Usuario [] = [];
  constructor(private usuarioService: UsuarioService){}


  //Se ejecuta cada vez que se carga el componente
  ngOnInit(): void {
    this.listUsuarios();
  }

  listUsuarios(){
    this.usuarioService.getUsuarioList().subscribe(
      data => {this.usuarios = data
      console.log(this.usuarios);
      }
    );
  }

  /**
   * Metodo para eliminar y actualizar la tabla de usuario
   * @param id 
   */
  eliminarUsuario(id:string){
    console.log('Eliminando usuario con el id '+id)//Para ver el id del usuario a eliminar
    this.usuarioService.eliminarUsuario(id).subscribe(
      () => this.listUsuarios()
    );
  }

}
