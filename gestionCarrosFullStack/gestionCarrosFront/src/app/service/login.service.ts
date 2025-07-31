import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../login';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private api : string = "http://localhost:8080/api/auth/login"
  constructor(private htt:HttpClient) { }

  loguearUsuario(login: Login):Observable<Login>{
    return this.htt.post<Login>(this.api, login)
  }
}
