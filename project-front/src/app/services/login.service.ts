import { environment } from './../../environments/environment.prod';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  // token = localStorage.getItem("token")!
  // headersoption = new HttpHeaders({
  //   "x-access-token": this.token
  // })
  constructor(private http:HttpClient) { }
  login(requestLogin: any) {
    return this.http.post(`${environment.baseUrl}/users/login`, requestLogin)
  }
  registerentreprise(requestRegister: any) {
    return this.http.post(`${environment.baseUrl}/users/entreprise/registerentreprise`, requestRegister)
  }

  registercandidat(requestRegister: any) {
    return this.http.post(`${environment.baseUrl}/users/candidat/registercandidat`, requestRegister)
  }

  logout() {
    return this.http.get(`http://localhost:8085/users/logout`)


  }


}
