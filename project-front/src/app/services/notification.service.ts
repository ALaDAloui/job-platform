import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http:HttpClient) { }



  createNotification(idoffre: any,notification:any){
    return this.http.post(`${environment.baseUrl}/users/notifications/save/${idoffre}`,notification)

  }

  getNotification(){
    return this.http.get(`${environment.baseUrl}/users/notifications/all`)
  }


}
