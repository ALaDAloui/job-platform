import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OffreService } from 'src/app/services/offre.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-offre-postuler',
  templateUrl: './offre-postuler.component.html',
  styleUrls: ['./offre-postuler.component.css']
})
export class OffrePostulerComponent implements OnInit {

  listCategorie:any

  closeResult = '';
  ajoutoffreForm: FormGroup;
  submitted = false;
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)



  constructor(private offreservice : OffreService, private formBuilder: FormBuilder,private route:Router, private apidata:OffreService,
    private activeroute:ActivatedRoute) { }

  ngOnInit(): void {
    this.getCategorie()


    this.ajoutoffreForm = this.formBuilder.group({
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
      nbrPoste: ['', Validators.required],
      status: ['', Validators.required]


  }  );

}

get f() { return this.ajoutoffreForm.controls; }

// ajouter une offre avec patchvalue: par defaut status en attente
onSubmit() {
  this.submitted = true;
this.ajoutoffreForm.patchValue({
  nbrPoste:Number(this.ajoutoffreForm.value.nbrPoste),
  status:"en attente"
})
   this.offreservice.createOffre(this.userconnect.id,this.ajoutoffreForm.value.CATEGORIE_ID,this.ajoutoffreForm.value).subscribe((res:any)=>{
    Swal.fire('offre ajoutée ! Attendre la validation de l administrateur ')
    console.log("offre",res)
    this.route.navigateByUrl('/entrepriseoffre')

    // display form values on success
  // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})


}


  getCategorie(){
    this.offreservice.getCategorie().subscribe((res:any)=>{
      this.listCategorie =res
      console.log("list of categorie",this.listCategorie)
  })
  }


}
