import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }


  login(requestLogin: any) {
    return this.http.post(`${environment.baseUrl}/users/login`, requestLogin)
  }
  registeradmistrateur(requestRegister: any) {
    return this.http.post(`${environment.baseUrl}/users/admin/registerAdmin`, requestRegister)
  }



}
