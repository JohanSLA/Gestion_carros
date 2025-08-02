import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Auto } from '../auto';

@Injectable({
  providedIn: 'root'
})
export class AutoService {

  private api : string = "http://localhost:8080/api/auto"

  constructor(private http:HttpClient) { }


  /**
     * Metodo para obtener los autos mediante una lista
     * @returns lista con usuarios
     */
    getAutoList(id: string):Observable<Auto []>{
      return this.http.get<Auto[]>(this.api+"/listar/autos/"+id);
    }

    /**
       * Metodo para agregar auto
       * @param usuario agregar
       * @returns 
       */
      agregarAuto(auto: Auto): Observable<Auto>{
        return this.http.post<Auto>(this.api+"/agregar", auto)
      }

    /**
       * Metodo que s eusa para eliminar un auto dado su placa
       * @param placa del auto a eliminar
       * @returns 
       */
      eliminarAuto(placa: string):Observable<any>{
        return this.http.delete(this.api+'/eliminar/'+placa)
      }

      /**
       * Metodo para actualizar los datos de un auto
       * @param auto 
       * @returns 
       */
      actualizarAuto(auto: Auto):Observable<Auto>{
        return this.http.patch<Auto>(this.api+'/actualizar',auto)
      }


}
