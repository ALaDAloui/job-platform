import { Router, ActivatedRoute } from '@angular/router';
import { EntrepriseService } from './../../services/entreprise.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-entreprise-profil',
  templateUrl: './entreprise-profil.component.html',
  styleUrls: ['./entreprise-profil.component.css']
})


export class EntrepriseProfilComponent implements OnInit {

  detailEntreprise:any
  id=this.activeroute.snapshot.params.id
  entreprise:any

  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor( private entrepriseService:EntrepriseService , private router: Router,private activeroute:ActivatedRoute) { }

  ngOnInit(): void {

    console.log("id userconnect",this.userconnect.id)
    this.getEntreprie()
    }

    getEntreprie(){
      this.entrepriseService.getOneEntreprise(this.id).subscribe((res:any)=>{
        this.detailEntreprise =res
        this.entreprise=res
        console.log("get entreprise by id",this.detailEntreprise)
    })
    }

}
