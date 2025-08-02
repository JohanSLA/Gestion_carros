import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Auto } from '../../auto';
import { AutoService } from '../../service/auto.service';
import { Usuario } from '../../usuario';
import { UsuarioService } from '../../service/usuario.service';
import { CanActivate, Router } from '@angular/router';
@Component({
  selector: 'app-home-usuario',
  imports: [FormsModule, CommonModule],
  templateUrl: './home-usuario.component.html',
  styleUrl: './home-usuario.component.css',
})
export class HomeUsuarioComponent implements OnInit {
  autos: Auto[] = [];

  placa: string = '';
  ano: string = '';
  color: string = '';
  marca: string = '';
  modelo: string = '';
  usuario: Usuario = JSON.parse(localStorage.getItem('usuario')!);
  constructor(
    private autoService: AutoService,
    private router: Router,
    private usuarioService: UsuarioService
  ) {}

  //Se ejecuta cada que se hace un cambio que se especifica dentro de este metodo (cuando ejecuta mas metodos)
  ngOnInit(): void {
    this.listAutos();
    const usuarioGuardado = localStorage.getItem('usuario');
    if (usuarioGuardado) {
      this.usuario = JSON.parse(usuarioGuardado);
      console.log('Usuario cargado:', this.usuario);
    }
  }

  /**
   * Metodo para listar los datos de un usuario en su pantalla
   */
  listAutos() {
    const usuarioGuardado = localStorage.getItem('usuario');
    if (usuarioGuardado) {
      const usuario = JSON.parse(usuarioGuardado);
      const id = usuario.id; //Obtiene el id del usuario
      console.log('Id del usuario logueado:' + id);
      this.autoService.getAutoList(id).subscribe((data) => {
        this.autos = data;
        console.log(this.autos);
      });
    } else {
      console.log('No se encontraron lista de autos para este usuario');
    }
  }

  /**
   * Metodo que permite asociar los datos de la plantilla html al componenete para guardar un auto
   */
  agregarAuto() {
    let auto = new Auto(
      this.placa,
      this.ano,
      this.color,
      this.marca,
      this.modelo,
      this.usuario
    );

    console.log(auto); //vemoos por consola el auto

    this.autoService.agregarAuto(auto).subscribe(() => this.listAutos());
  }

  /**
   * Metodo para eliminar y actualizar la tabla de usuario
   * @param id
   */
  eliminarAuto(placa: string) {
    //Confirmación para eliminar el auto del usuario
    const confirmar = window.confirm(
      '¿Estás seguro de que deseas eliminar elo auto con placa? ' + placa
    );

    if (confirmar) {
      console.log('Eliminando auto con la placa ' + placa); //Para ver la placa  del usuario a eliminar
      this.autoService.eliminarAuto(placa).subscribe(() => this.listAutos());
      alert('Se elimino con exito el auto con placa ' + placa);
    } else {
      alert('Eliminación cancelada');
    }
  }

  //Para actualizar los datos de los autos seleccionados al dar click en modificar
  autoSeleccionado: any = {};

  prepararAuto(auto: any) {
    this.autoSeleccionado = { ...auto };
  }

  /**
   * Metodo para actualizar la info del auto actualizado
   */
  actualizarAuto() {
    this.autoService.actualizarAuto(this.autoSeleccionado).subscribe(() => {
      alert('Auto actualizado correctamente');
      this.listAutos(); // refresca la lista de autos
    });
  }

  /**
   * Metodo mediante se limpian los campos del usuario
   */
  limpiarInputs() {
    this.placa = '';
    this.ano = '';
    this.color = '';
    this.marca = '';
    this.modelo = '';
  }

  /**
   * Metodo con el fin de cerrar la seccion del usuario , destruir los datos del localstorage
   */
  cerrarUsuario() {
    alert('Adios, vuelve pronto!');
    // Guarda el token en localStorage
    localStorage.removeItem('token');
    localStorage.removeItem('usuario');
    localStorage.clear;

    // Redirige al home o cualquier ruta
    this.router.navigate(['/login']);
  }

  

  //Para actualizar los datos del usuario 

  usuarioSeleccionado: any = {};

  /**
   * Metodo que obtiene al usuario dado el id del localStorage
   * @param usuario
   */
  prepararUsuario() {
    const usuarioGuardado = localStorage.getItem('usuario');

    if (usuarioGuardado) {
      const usuario = JSON.parse(usuarioGuardado);
      const id = usuario.id;
      console.log('usuario con id:'+id)

      this.usuarioService.obtenerUsuario(id).subscribe((res) => {
        this.usuarioSeleccionado = { ...res }; 
        this.usuarioSeleccionado.password = ''; 
      });
    } else {
      alert('Problemas al decifrar el id del usuario');
    }
  }

  /**
   * Metodo para actualizar la info del auto actualizado Nota: faltaaaa
   */
  actualizarUsuario() {
    this.usuarioService
      .actualizarUsuario(this.usuarioSeleccionado)
      .subscribe(() => {
        alert('Usuario actualizado correctamente');
      });
  }
}
