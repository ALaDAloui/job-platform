import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class EntrepriseService {

  constructor(private http:HttpClient) {
   }


   getEntreprise(){
    return this.http.get(`${environment.baseUrl}/users/entreprise/all`)
  }


  getOneEntreprise(id:any){
    return this.http.get(`${environment.baseUrl}/users/entreprise/GetOne/${id}`)
  }

  updateEntreprise(id:any, entreprise:any) {
    return this.http.put(`${environment.baseUrl}/users/entreprise/update/${id}`,entreprise)
  }
  deleteEntreprise(id:any){
    return this.http.delete(`${environment.baseUrl}/users/entreprise/delete/${id}`)
  }

  updateImage(id:any, entreprise:any) {
    return this.http.put(`${environment.baseUrl}/users/entreprise/modifimage/${id}`,entreprise)
  }


  getCandidature(id:any){
    return this.http.get(`${environment.baseUrl}/users/candidature/all/${id}`)
  }


  putEtat1(id:any){
    return this.http.put(`${environment.baseUrl}/users/candidature/etat1/${id}`,{})
  }
  putEtat2(id:any){
    return this.http.put(`${environment.baseUrl}/users/candidature/etat2/${id}`,{})
  }


  etatEntreprie1(id:any){
    return this.http.put(`${environment.baseUrl}/users/entreprise/etat1/${id}`,{})
  }
  etatEntreprie2(id:any){
    return this.http.put(`${environment.baseUrl}/users/entreprise/etat2/${id}`,{})
  }

  addEntretien(identreprise:any,idcandidature:any,entretien:any){
    return this.http.post(`${environment.baseUrl}/users/entretien/add/${identreprise}/${idcandidature}`,entretien)
  }

  getEntretien(id:any){
    return this.http.get(`${environment.baseUrl}/users/entretien/getc/${id}`)
  }


  updateDescription(id:any, offre:any) {
    return this.http.put(`${environment.baseUrl}/users/offre/update/${id}`,offre)
  }


  putDescription(id:any , description:any){
    return this.http.put(`${environment.baseUrl}/users/entreprise/updatedescr/${id}`,description)
  }




}
