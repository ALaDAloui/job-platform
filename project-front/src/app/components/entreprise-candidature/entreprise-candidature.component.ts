import { MailService } from './../../services/mail.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { EntrepriseService } from './../../services/entreprise.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-entreprise-candidature',
  templateUrl: './entreprise-candidature.component.html',
  styleUrls: ['./entreprise-candidature.component.css']
})
export class EntrepriseCandidatureComponent implements OnInit {

  listcandidature:any
  listentretien:any
  id=this.activeroute.snapshot.params.id
  offre:any

  private updateSubscription: Subscription;
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  idcandidature:any

  closeResult = '';
  emailForm: FormGroup;
  entretienform:FormGroup;
  submitted = false;

  constructor(private modalService: NgbModal , private formBuilder: FormBuilder,private entrepriseservice:EntrepriseService
    ,private mailService:MailService,private activeroute:ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getCandidatureByOffre()
    this.getEntretienByCandidature()

    this.emailForm =this.formBuilder.group({
      to: ['', Validators.required],
      subject: ['', Validators.required],
      content: ['', Validators.required],
      url:['', Validators.required],
      date:['', Validators.required],
      time:['', Validators.required],
    }, )
    this.entretienform =this.formBuilder.group({
      lienEntretien:['', Validators.required],
      dateEntretien:['', Validators.required],
      time:['', Validators.required],
      accepte:['', Validators.required]
    }, )
  }


  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    // if (this.experienceForm.invalid) {
    //     return;
    // }
    this.emailForm.patchValue({

      content:
       this.emailForm.value.content
        + '  ' +
       'Ceci est le lien de l entretien :' +
       + '  ' +
        this.emailForm.value.url  + '  Date : ' +
        + '  ' +
        this.emailForm.value.date  +  '  Heure : ' +
        + '  ' +
        this.emailForm.value.time

    });

    this.mailService.createMail(this.emailForm.value).subscribe((res:any)=>{

      console.log("email",res)

    // display form values on success
    // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})
this.entretienform.patchValue({
  lienEntretien:this.emailForm.value.url,
  dateEntretien:this.emailForm.value.date,
  time:this.emailForm.value.time,
  
  accepte:"en cours"

})
console.log("id candidature",this.idcandidature)
this.entrepriseservice.addEntretien(this.userconnect.id,this.idcandidature,this.entretienform.value).subscribe((res:any)=>{
  console.log("entretien",res)
  Swal.fire('Mail envoyé')
})
  }

  getCandidatureByOffre(){
    this.entrepriseservice.getCandidature(this.id).subscribe((res:any)=>{
      this.listcandidature=res
      this.offre=res
      console.log("list of candidature",this.listcandidature)
  })
  }
  getEntretienByCandidature(){
    console.log("id candidature",this.idcandidature)
    this.entrepriseservice.getEntretien(this.idcandidature).subscribe((res:any)=>{
      this.listentretien=res
      this.idcandidature=res
      console.log("list of entretien by candidature",this.listentretien)
  })
  }

  updateEtat1(id:any){
    this.entrepriseservice.putEtat1(id).subscribe((res:any)=>{
   Swal.fire("candidature valider")
   window.location.href="http://localhost:4200/listcandidature/"

      console.log("candidature",res)
      // window.location.href="http://localhost:4200/listcandidature/29"
  })
  }

  updateEtat2(id:any){
    this.entrepriseservice.putEtat2(id).subscribe((res:any)=>{
   Swal.fire("candidature refuser")
   window.location.href="http://localhost:4200/listcandidature/{id}"
      console.log("candidature",res)
  })
  }

  // onSubmit1() {
  //   this.submitted = true;

  //   // stop here if form is invalid
  //   // if (this.experienceForm.invalid) {
  //   //     return;
  //   // }
  //   this.condidatservice.createFormation(this.userconnect.id,this.formationForm.value).subscribe((res:any)=>{

  //     console.log("formation",res)
  //   Swal.fire('formation added')
  //   // display form values on success
  //   // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
  // })


  // }
  open(content:any,id:any) {
    this.idcandidature=id
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
