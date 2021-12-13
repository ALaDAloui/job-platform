import { ExamenService } from './../../../services/examen.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-examen',
  templateUrl: './list-examen.component.html',
  styleUrls: ['./list-examen.component.css']
})
export class ListExamenComponent implements OnInit {


  listExamen:any
  id=this.activeroute.snapshot.params.id
  offre:any

idexamen:any
  closeResult = '';
  examForm: FormGroup;
  questionForm:FormGroup;
  submitted = false;

  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private modalService: NgbModal,private formBuilder: FormBuilder ,private examenService : ExamenService,
    private router: Router, private activeroute:ActivatedRoute) { }

  ngOnInit(): void {
    this.getExamByOffre()


    this.examForm =this.formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      maxMarks: ['', Validators.required],
      numberOfQuestions: ['', Validators.required],

    }, )

    this.questionForm =this.formBuilder.group({
      content: ['', Validators.required],
      option1: ['', Validators.required],
      option2: ['', Validators.required],
      option3: ['', Validators.required],
      option4: ['', Validators.required],
      answer: ['', Validators.required],

    }, )

    console.log("id userconnect",this.userconnect.id)

  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    // if (this.experienceForm.invalid) {
    //     return;
    // }
    this.examenService.createExamen(this.userconnect.id,this.id,this.examForm.value).subscribe((res:any)=>{

      console.log("examen",res)
    Swal.fire('examen ajouté')
    window.location.href="http://localhost:4200/listexamen/{id}"

    // display form values on success
    // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})
}
onSubmit1() {
  this.submitted = true;

  // stop here if form is invalid
  // if (this.experienceForm.invalid) {
  //     return;
  // }
  console.log(this.idexamen)
  this.examenService.createQuestion(this.idexamen,this.questionForm.value).subscribe((res:any)=>{

    console.log("question",res)
  Swal.fire('question ajouté')
  // display form values on success
  // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})
}
open(content:any) {
  this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}

open1(content:any,examen:any) {
  this.idexamen=examen.exId
console.log("id examen",this.idexamen)
  this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });



}

private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
  } else {
    return `with: ${reason}`;
  }
}
  getExamByOffre(){
    this.examenService.getExamenByOffres(this.id).subscribe((res:any)=>{
      this.listExamen=res
      console.log("list of examens",this.listExamen)
  })
  }

  deleteExam(id:any){
    Swal.fire({
      title: 'Êtes vous sûrs??',
      text: "Vous ne pourrez pas revenir en arrière",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Oui, supprimer le!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.examenService.deleteExam(id.exId).subscribe( data => {
        Swal.fire(
          'Supprimer!',
          'L examen est bien supprimé.',
          'success'
        )
        window.location.href="http://localhost:4200/listexamen/{id}"

      })
    }
    // console.log(data);
    // this.listproduct();

})



}

}
