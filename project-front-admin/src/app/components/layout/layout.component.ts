import { EntrepriseService } from './../../services/entreprise.service';
import { OffreService } from './../../services/offre.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  listoffre:any
  listEntreprise:any
  listcandidature:any
  constructor(private offreService: OffreService , private entrepriseService:EntrepriseService) { }

  ngOnInit(): void {
    this.getOffre()
    this.getEntreprise()
    this.getCandidature()

  }


  getOffre(){
    this.offreService.getoffre().subscribe((res:any)=>{
      this.listoffre =res

      console.log("list of offres",this.listoffre)
  })
  }

  getEntreprise(){
    this.entrepriseService.getEntreprise().subscribe((res:any)=>{
      this.listEntreprise =res
      console.log("list of entreprises",this.listEntreprise)
  })
  }

  getCandidature(){
    this.offreService.getcandidature().subscribe((res:any)=>{
      this.listcandidature =res

      console.log("list of offres",this.listcandidature)
  })
  }

}
