import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OffreService } from 'src/app/services/offre.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  listCategorie:any
  listoffre:any
  listrandom:any

  category=""
  searchform : FormGroup;
  submitted = false;

  constructor(private formBuilder :FormBuilder,private route:Router,private offreservice : OffreService) { }

  ngOnInit(): void {
    this.getCategorie()
    this.getOffre()
    this.getrandomOffre()

    this.searchform = this.formBuilder.group({
      titre: ['', Validators.required],
     region: ['', Validators.required],
     categorie_id: ['', Validators.required],

  });

  }

  getCategorie(){
    this.offreservice.getCategorie().subscribe((res:any)=>{
      this.listCategorie =res
      console.log("list of categorie",this.listCategorie)
  })
  }

  getOffre(){
    this.offreservice.getoffre().subscribe((res:any)=>{
      this.listoffre =res
      console.log("list of offre",this.listoffre)
  })
  }

  getrandomOffre(){
    this.offreservice.getRandomoffre().subscribe((res:any)=>{
      this.listrandom =res
      console.log("list of random offre",this.listrandom)
  })
  }


  getoffrebytitle() {
    this.offreservice.getoffre().subscribe((res:any)=>{
      this.listoffre =res.filter((el:any)=>el.titre==this.searchform.value.titre && el.region==this.searchform.value.region )
      console.log("list of offres",this.listoffre)
  })
  }
  getoffrebycategory(e:any){
  console.log("categorie selectione",e.target.value)
  this.route.navigateByUrl(`/listoffre/${e.target.value}`)

  // this.route.navigateByUrl(`/listoffre/${event.target.value}`)
  }


}
