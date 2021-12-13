import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { OffreService } from 'src/app/services/offre.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-entreprise-offre-list',
  templateUrl: './entreprise-offre-list.component.html',
  styleUrls: ['./entreprise-offre-list.component.css']
})
export class EntrepriseOffreListComponent implements OnInit {

  listCategorie:any

  detailoffre:any
  id=this.activeroute.snapshot.params.id
  offre:any

  closeResult = '';
  offreUpdateForm: FormGroup;
  submitted = false;

  listoffre:any
  offre1:any
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private modalService: NgbModal,private formBuilder: FormBuilder ,private offreservice : OffreService,
    private router: Router, private activeroute:ActivatedRoute) { }

  ngOnInit(): void {
    this.getOffreByEntreprise()
    this.getCategorie()


    console.log("id userconnect",this.userconnect.id)
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

  // getOffre(){
  //   this.offreservice.getOneOffre(this.id).subscribe((res:any)=>{
  //     this.detailoffre =res
  //     this.offre=res
  //     console.log("get OFFRE by id",this.detailoffre)
  //     console.log("offre",this.offre)
  // })
  // }

  updateOffre(){
    this.offreservice.updateOffre(this.offreUpdateForm.value.id,this.offreUpdateForm.value).subscribe(res=>{
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
    this.offreservice.getCategorie().subscribe((res:any)=>{
      this.listCategorie =res
      console.log("list of categorie",this.listCategorie)
  })
  }
//// affichier les offres avec status "valider " seulement : .filter
  getOffreByEntreprise(){
    this.offreservice.getOffreByEntreprise(this.userconnect.id).subscribe((res:any)=>{
      this.listoffre=res.filter((el:any)=>el.status=='valider')
      console.log("list of offres",this.listoffre)
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
          this.offreservice.deleteOffre(id).subscribe( data => {
          console.log("offre deleted",data)
          Swal.fire(
            'Supprimer!',
            'Loffre est bien supprimé.',
            'success'
          )
        })
      }
      // console.log(data);
      // this.listproduct();

  })



}
}
