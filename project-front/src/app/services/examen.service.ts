import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class ExamenService {

  constructor(private http:HttpClient) { }



  createExamen(identreprise: any,idoffre:any,examen:any) {
    return this.http.post(`${environment.baseUrl}/users/exam/add/${identreprise}/${idoffre}`,examen)
  }

  getExamenByOffres(id:any){
    return this.http.get(`${environment.baseUrl}/users/exam/allexam/${id}`)
  }

  getOneExam(id:any){
    return this.http.get(`${environment.baseUrl}/users/exam/GetOne/${id}`)
  }


  getRandomExamenByOffres(id:any){
    return this.http.get(`${environment.baseUrl}/users/exam/oneExam/${id}`)
  }

  createQuestion(id:any,question:any) {
    return this.http.post(`${environment.baseUrl}/users/question/add/${id}`,question)
  }

  getQuestionsbyExam(id:any){
    return this.http.get(`${environment.baseUrl}/users/question/all/${id}`)
  }

  deleteExam(id:any){
    return this.http.delete(`${environment.baseUrl}/users/exam/delete/${id}`)
  }

  getQuestionByExamen(id:any){
    return this.http.get(`${environment.baseUrl}/users/question/all/${id}`)
  }

  updateNote(id:any, note:any) {
    return this.http.put(`${environment.baseUrl}/users/candidature/updatenote/${id}`,note)
  }



}
