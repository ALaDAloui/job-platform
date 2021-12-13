import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(private http:HttpClient) { }


  getCategorie(){
    return this.http.get(`${environment.baseUrl}/users/categorie/all`)
  }

  createCategorie(categorie:any) {
    return this.http.post(`${environment.baseUrl}/users/categorie/save/`,categorie)
  }

  updateCategorie(id:any, categorie:any) {
    return this.http.put(`${environment.baseUrl}/users/categorie/update/${id}`,categorie)
  }

  deleteCategorie(id:any){
    return this.http.delete(`${environment.baseUrl}/users/categorie/delete/${id}`)
  }



}
