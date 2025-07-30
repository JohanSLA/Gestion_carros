import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private api : string = "http://localhost:8080/api/usuario"
  
  constructor(private http:HttpClient) { }

  /**
   * Metodo para obtener los usuarios mediante una lista
   * @returns lista con usuarios
   */
  getUsuarioList():Observable<Usuario []>{
    return this.http.get<Usuario[]>(this.api);
  }



  /**
   * Metodo para agregar usuario
   * @param usuario agregar
   * @returns 
   */
  agregarUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(this.api, usuario)
  }


  /**
   * Metodo que s eusa para eliminar un usuario dado su id
   * @param id del usuario a eliminar
   * @returns 
   */
  eliminarUsuario(id: string):Observable<any>{
    return this.http.delete(this.api+'/'+id)
  }



}
