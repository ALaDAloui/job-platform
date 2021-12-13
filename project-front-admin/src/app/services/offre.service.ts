import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OffreService {

  constructor(private http:HttpClient) { }



  getoffre(){
    return this.http.get(`${environment.baseUrl}/users/offre/all`)
  }

  deleteOffre(id:any){
    return this.http.delete(`${environment.baseUrl}/users/offre/delete/${id}`)
  }

  putStatus1(id:any){
    return this.http.put(`${environment.baseUrl}/users/offre/status1/${id}`,{})
  }
  putstatus2(id:any){
    return this.http.put(`${environment.baseUrl}/users/offre/status2/${id}`,{})
  }

  updateOffre(id:any, offre:any) {
    return this.http.put(`${environment.baseUrl}/users/offre/update/${id}`,offre)
  }
  getCategorie(){
    return this.http.get(`${environment.baseUrl}/users/categorie/all`)
  }


  getcandidature(){
    return this.http.get(`${environment.baseUrl}/users/candidature/all`)
  }

}
