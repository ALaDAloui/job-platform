import { NotificationService } from './../../services/notification.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription, interval } from 'rxjs';
import { OffreService } from './../../services/offre.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-entreprise-offre',
  templateUrl: './entreprise-offre.component.html',
  styleUrls: ['./entreprise-offre.component.css']
})

export class EntrepriseOffreComponent implements OnInit {

  listoffre:any

  d=this.activeroute.snapshot.params.id
  offre:any

  listCategorie: any

  closeResult = '';
  offreUpdateForm: FormGroup;
  submitted = false;

  private updateSubscription: Subscription;


  constructor(private modalService: NgbModal,private formBuilder: FormBuilder, private offreService: OffreService, private notificationService:NotificationService ,
      private router: Router, private activeroute:ActivatedRoute) { }

  ngOnInit(): void {

    this.getOffre()


    this.offreUpdateForm = this.formBuilder.group({
      id: ['', Validators.required],
      competence: ['', Validators.required],
      connaissance_technique: ['', Validators.required],
      description: ['', Validators.required],
      salaire: ['', Validators.required],
      region: ['', Validators.required],
      titre: ['', Validators.required],
      experience: ['', Validators.required],
      typeContrat: ['', Validators.required],
      typeemploi: ['', Validators.required] ,
      niveauEtudes: ['', Validators.required] ,
      CATEGORIE_ID: ['', Validators.required] ,
      nbrPoste: ['', Validators.required]
  }  );
  }

  getOffre(){
    this.offreService.getoffre().subscribe((res:any)=>{
      this.listoffre =res

      console.log("list of offres",this.listoffre)
  })
  }


  updateOffre(){
    this.offreService.updateOffre(this.offreUpdateForm.value.id,this.offreUpdateForm.value).subscribe(res=>{
      console.log(res,"update offre")
      Swal.fire(
        'OFFRE UPDATE!',
        'Your OFFRE has been updated.',
        'success'
      )

     })
  }

open(content:any,offre:any) {

  this.offreUpdateForm.setValue({
    id:offre.id,
    competence:offre.competence,
    connaissance_technique:offre.connaissance_technique,
    description:offre.description,
    salaire:offre.salaire,
    region:offre.region,
    titre:offre.titre,
    experience:offre.experience,
    typeContrat:offre.typeContrat,
    typeemploi:offre.typeemploi,
    niveauEtudes:offre.niveauEtudes,
    CATEGORIE_ID:offre.co.nom,
    nbrPoste:offre.nbrPoste,

  })

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

  getCategorie(){
    this.offreService.getCategorie().subscribe((res:any)=>{
      this.listCategorie =res
      console.log("list of categorie",this.listCategorie)
  })
  }

  updateStatus1(id:any){
    this.offreService.putStatus1(id).subscribe((res:any)=>{
   Swal.fire("offre valider")
   window.location.href="http://localhost:3000/home/offre"

      console.log("candidature",res)
      // window.location.href="http://localhost:4200/listcandidature/29"
  })

    this.notificationService.createNotification(id).subscribe((res:any)=>{

      console.log("notification" , res)
    })
  }

  updateStatus2(id:any){
    this.offreService.putstatus2(id).subscribe((res:any)=>{
   Swal.fire("offre refuser")
   window.location.href="http://localhost:3000/home/offre"

      console.log("candidature",res)

  })
  }

  deleteOffre(id: any){
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
        this.offreService.deleteOffre(id).subscribe( data => {
        Swal.fire(
          'Supprimer!',
          'Loffre est bien supprimé.',
          'success'
        )
      })
      window.location.href="http://localhost:3000/home/offre"
    }
    // console.log(data);
    // this.listproduct();

})



}

}
