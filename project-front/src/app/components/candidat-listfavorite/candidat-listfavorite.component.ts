import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OffreService } from 'src/app/services/offre.service';

@Component({
  selector: 'app-candidat-listfavorite',
  templateUrl: './candidat-listfavorite.component.html',
  styleUrls: ['./candidat-listfavorite.component.css']
})
export class CandidatListfavoriteComponent implements OnInit {


  listfavorite:any
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private offreservice:OffreService , private router: Router) { }

  ngOnInit(): void {
    this.getListeFavoriteByUser()


  }

  getListeFavoriteByUser(){
    this.offreservice.getListeFavorite(this.userconnect.id).subscribe((res:any)=>{
      this.listfavorite=res
      console.log("list of favorite",this.listfavorite)
  })
  }
}
