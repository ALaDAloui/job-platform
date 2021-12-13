import { environment } from './../../environments/environment.prod';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CandidatService {

  constructor(private http:HttpClient) { }

  getcandidat(){
    return this.http.get(`${environment.baseUrl}/users/candidat/all`)
  }

  getOneCandidat(id:any){
    return this.http.get(`${environment.baseUrl}/users/candidat/GetOne/${id}`)
  }

  createExperience(id: any,experience:any){
    return this.http.post(`${environment.baseUrl}/users/experience/add/${id}`,experience)

  }
  createFormation(id: any,formation:any){
    return this.http.post(`${environment.baseUrl}/users/formation/add/${id}`,formation)

  }

  getExperience(id:any){
    return this.http.get(`${environment.baseUrl}/users/experience/all/${id}`)
  }

  getCandidature(id:any){
    return this.http.get(`${environment.baseUrl}/users/candidature/allc/${id}`)
  }

  getFormation(id:any){
    return this.http.get(`${environment.baseUrl}/users/formation/all/${id}`)
  }

  deleteCandidature(id:any){
    return this.http.delete(`${environment.baseUrl}/users/candidature/delete/${id}`)
  }

  getEntretien(id:any){
    return this.http.get(`${environment.baseUrl}/users/entretien/getcc/${id}`)
  }


  getEntretienbycandidature(id:any){
    return this.http.get(`${environment.baseUrl}/users/entretien/getc/${id}`)
  }

  getEntretienn(){
    return this.http.get(`${environment.baseUrl}/users/entretien/all`)
  }

}
