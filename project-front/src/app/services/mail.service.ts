import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MailService {

  constructor(private http:HttpClient) { }



  createMail(mail:any) {
    return this.http.post(`${environment.baseUrl}/users/email/sendMail`,mail)
  }

}
