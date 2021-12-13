import { Router, ActivatedRoute } from '@angular/router';
import { OffreService } from './../../services/offre.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-offre-list',
  templateUrl: './offre-list.component.html',
  styleUrls: ['./offre-list.component.css']

})
export class OffreListComponent implements OnInit {
  listCategorie:any
  term_search:any=""
  term_search1:any=""
  searchform : FormGroup;
  listoffre:any
  category=""
  type_selectionee=""

//pagination
p: number = 1;


  id=this.activeroute.snapshot.params.id
  offre:any
  ListFavorite:any
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private activeroute:ActivatedRoute ,private offreservice : OffreService,
    private router: Router,private formBuilder :FormBuilder) { }

  ngOnInit(): void {
    this.getOffre()
    this.getCategorie()
    this.searchform = this.formBuilder.group({
      titre: ['', Validators.required],
     region: ['', Validators.required],
     co: ['', Validators.required],

  });
  }

  onSubmit(offre:any) {
    console.log("id offre",offre.id)
    console.log("userconnect",this.userconnect.id)
     this.offreservice.addListeFavorite(this.userconnect.id,offre.id).subscribe((res:any)=>{
      Swal.fire('+1 Liste favorite')
    // display form values on success
    // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})

}

  getOffre(){
    this.offreservice.getoffre().subscribe((res:any)=>{
      this.listoffre =res.filter((el:any)=>el.status=='valider')
      console.log("list of offres",this.listoffre)
  })
  }
// filtrage avec pipe
   Onchangetype(event:any){
   console.log("type selectione",event.target.value)
   this.offreservice.getoffre().subscribe((res:any)=>{
    this.listoffre =res.filter((el:any)=>el.typeemploi==event.target.value)
    console.log("list of offres types",this.listoffre)
})
  }
// filtrage avec pipe

  Onchangetype1(event:any){
    console.log("type selectione",event.target.value)
    this.offreservice.getoffre().subscribe((res:any)=>{
     this.listoffre =res.filter((el:any)=>el.typeContrat==event.target.value)
     console.log("list of offres types",this.listoffre)
 })

}

// filtrage avec pipe

Onchangetype2(event:any){
  console.log("type selectione",event.target.value)
  this.offreservice.getoffre().subscribe((res:any)=>{
   this.listoffre =res.filter((el:any)=>el.salaire==event.target.value)
   console.log("list of offres types",this.listoffre)
})

}
// filtrage avec titre + region


  getoffrebytitle() {
    this.offreservice.getoffre().subscribe((res:any)=>{
      this.listoffre =res.filter((el:any)=>el.titre==this.searchform.value.titre && el.region==this.searchform.value.region  )
      console.log("list of offres",this.listoffre)
  })
  }

// filtrage avec categorie

  changeoffrebycategory(event:any){
    // console.log("category",this.category)
    this.offreservice.getoffre().subscribe(
      (data:any) => {
        this.listoffre = data.filter((el:any)=> el.co.id==event.target.value )
       console.log("offre d'emploi", this.listoffre)
      })
  }
  getCategorie(){
    this.offreservice.getCategorie().subscribe((res:any)=>{
      this.listCategorie =res
      console.log("list of categorie",this.listCategorie)
  })
  }



}
