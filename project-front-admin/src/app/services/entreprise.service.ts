import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EntrepriseService {

  constructor(private http:HttpClient) {
  }

  getEntreprise(){
    return this.http.get(`${environment.baseUrl}/users/entreprise/all`)
  }

  deleteEntreprise(id:any){
    return this.http.delete(`${environment.baseUrl}/users/entreprise/delete/${id}`)
  }

  etatEntreprie1(id:any){
    return this.http.put(`${environment.baseUrl}/users/entreprise/etat1/${id}`,{})
  }

  etatEntreprie2(id:any){
    return this.http.put(`${environment.baseUrl}/users/entreprise/etat2/${id}`,{})
  }

 

}
