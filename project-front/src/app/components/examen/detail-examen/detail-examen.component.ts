import { ActivatedRoute, Router } from '@angular/router';
import { ExamenService } from './../../../services/examen.service';
import { FormBuilder } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detail-examen',
  templateUrl: './detail-examen.component.html',
  styleUrls: ['./detail-examen.component.css']
})
export class DetailExamenComponent implements OnInit {

  detailExamen:any
  listquestion:any
  
  id=this.activeroute.snapshot.params.id
  examen:any
  idexamen:any
  closeResult = '';

  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private modalService: NgbModal,private formBuilder: FormBuilder ,private examenService : ExamenService,
    private router: Router, private activeroute:ActivatedRoute) { }



  ngOnInit(): void {
    this.getOneExam()
    this.getQuestionByExam()
  }


  getOneExam(){
    this.examenService.getOneExam(this.id).subscribe((res:any)=>{
      this.detailExamen =res
      this.examen=res
      console.log("get examen by id",this.detailExamen)
  })
  }

  // getExamByOffre(){
  //   this.examenService.getExamenByOffres(this.id).subscribe((res:any)=>{
  //     this.listExamen=res
  //     console.log("list of one exam",this.listExamen)
  // })
  // }

  getQuestionByExam(){
    this.examenService.getQuestionByExamen(this.id).subscribe((res:any)=>{
      this.listquestion=res
      console.log("list of questions",this.listquestion)
  })
  }


}
