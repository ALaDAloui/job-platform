import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class OffreService {

  constructor(private http:HttpClient) {}

    getoffre(){
      return this.http.get(`${environment.baseUrl}/users/offre/all`)
    }

    getRandomoffre(){
      return this.http.get(`${environment.baseUrl}/users/offre/RandomOffre`)
    }

    getOneOffre(id:any){
      return this.http.get(`${environment.baseUrl}/users/offre/GetOne/${id}`)
    }


    getOffreByEntreprise(id:any){
      return this.http.get(`${environment.baseUrl}/users/offre/all/${id}`)
    }

    createOffre(identreprise: any,idcategorie:any,offre:any) {
      return this.http.post(`${environment.baseUrl}/users/offre/add/${identreprise}/${idcategorie}`,offre)
    }

    updateOffre(id:any, offre:any) {
      return this.http.put(`${environment.baseUrl}/users/offre/update/${id}`,offre)
    }

    deleteOffre(id:any){
      return this.http.delete(`${environment.baseUrl}/users/offre/delete/${id}`)
    }


    getCommentaire(id:any){
      return this.http.get(`${environment.baseUrl}/users/commentaire/all/${id}`)
    }


    createCommentaire(idoffre: any,iduser:any,commentaire:any){
      return this.http.post(`${environment.baseUrl}/users/commentaire/add/${idoffre}/${iduser}`,commentaire)

    }

    getReponse(id:any){
      return this.http.get(`${environment.baseUrl}/users/reponse/all/${id}`)
    }


    createReponse(idcommentaire: any,iduser:any,reponse:any){
      return this.http.post(`${environment.baseUrl}/users/reponse/add/${idcommentaire}/${iduser}`,reponse)

    }

    getCategorie(){
      return this.http.get(`${environment.baseUrl}/users/categorie/all`)
    }

    createCandidature(candidature:any, id_offre: any,id_candidat:any) {
      return this.http.post(`${environment.baseUrl}/users/candidature/addcand/${id_offre}/${id_candidat}`,candidature)
    }



    addListeFavorite(iduser:any,idoffre:any){
      return this.http.post(`${environment.baseUrl}/users/listefavorite/save/${iduser}/${idoffre}`,{})

    }


    getListeFavorite(id:any){
      return this.http.get(`${environment.baseUrl}/users/listefavorite/all/${id}`)
    }
}
