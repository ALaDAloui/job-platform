import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { CandidatService } from 'src/app/services/candidat.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-candidat-profil',
  templateUrl: './candidat-profil.component.html',
  styleUrls: ['./candidat-profil.component.css']
})
export class CandidatProfilComponent implements OnInit {

  closeResult = '';
  experienceForm: FormGroup;
  formationForm: FormGroup;
  submitted = false;

  listformation:any
  listexperience:any

  listcandidat:any

userconnect=JSON.parse(localStorage.getItem("userconnect")!)
  constructor(private modalService: NgbModal , private formBuilder: FormBuilder,private condidatservice:CandidatService , private router: Router,) { }

  ngOnInit(): void {
      this.getExperienceByUser()
      this.getFormationByUser()
      this.getCandidat()

    this.formationForm =this.formBuilder.group({
      ecole: ['', Validators.required],
      diplome: ['', Validators.required],
      domaineEtude: ['', Validators.required],
      dateDebut: ['', Validators.required],
      dateFin: ['', Validators.required],
      description: ['', Validators.required],
      resultat: ['', Validators.required],

    }, )

    this.experienceForm = this.formBuilder.group({
      nomPoste: ['', Validators.required],
      typeEmploi: ['', Validators.required],
      nomEntreprise: ['', Validators.required],
      lieu: ['', Validators.required],
      dateDebut: ['', Validators.required],
      dateFin: ['', Validators.required],
      titre: ['', Validators.required],
      secteur: ['', Validators.required],


  }, );
  console.log("id userconnect",this.userconnect.id)

  }

  getCandidat(){
    this.condidatservice.getcandidat().subscribe((res:any)=>{
      this.listcandidat =res
      console.log("list of candidats",this.listcandidat)
  })
  }


  getExperienceByUser(){
    this.condidatservice.getExperience(this.userconnect.id).subscribe((res:any)=>{
      this.listexperience=res
      console.log("list of experiencess",this.listexperience)
  })
  }
  getFormationByUser(){
    this.condidatservice.getFormation(this.userconnect.id).subscribe((res:any)=>{
      this.listformation=res
      console.log("list of formations",this.listformation)
  })
  }


// Bouton ajout expérience (onsubmit + open + getDismissReason)
  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    // if (this.experienceForm.invalid) {
    //     return;
    // }
    this.condidatservice.createExperience(this.userconnect.id,this.experienceForm.value).subscribe((res:any)=>{

      console.log("experience",res)
    Swal.fire('experience ajouté')
    window.location.href="http://localhost:4200/profil"
    // display form values on success
    // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})


}
//  ajout formation (onsubmit1 + open1 + getDismissReason)
onSubmit1() {
  this.submitted = true;

  // stop here if form is invalid
  // if (this.experienceForm.invalid) {
  //     return;
  // }
  this.condidatservice.createFormation(this.userconnect.id,this.formationForm.value).subscribe((res:any)=>{

    console.log("formation",res)
  Swal.fire('formation ajoutée')
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

open1(content:any) {
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
}
