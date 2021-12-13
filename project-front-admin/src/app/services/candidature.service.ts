import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CandidatureService {

  constructor(private http:HttpClient) { }


  getCandidature(id:any){
    return this.http.get(`${environment.baseUrl}/users/candidature/all/${id}`)
  }


  deleteCandidature(id:any){
    return this.http.delete(`${environment.baseUrl}/users/candidature/delete/${id}`)
  }

}
