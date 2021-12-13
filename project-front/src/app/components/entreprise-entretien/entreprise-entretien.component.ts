import { EntrepriseService } from './../../services/entreprise.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CandidatService } from 'src/app/services/candidat.service';

@Component({
  selector: 'app-entreprise-entretien',
  templateUrl: './entreprise-entretien.component.html',
  styleUrls: ['./entreprise-entretien.component.css']
})
export class EntrepriseEntretienComponent implements OnInit {


  listentretien:any
  id=this.activeroute.snapshot.params.id
  candidature:any
date=new Date().toISOString().split('T')[0].toString()
// date1=new Date()
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

   d = new Date();
 hours = this.d.getHours();
  constructor(private entrepriseservice:EntrepriseService ,private activeroute:ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getEntretienByCandidature()
console.log("date",this.date)

console.log("heure",this.hours);



  }

  getEntretienByCandidature(){
    this.entrepriseservice.getEntretien(this.id).subscribe((res:any)=>{
      this.listentretien=res
      this.candidature=res
      console.log("list of entretien",this.listentretien)
  })
  }

  passer(e:any){
    // && e.heure==
    console.log("heure",this.hours)
    return this.date==e.dateEntretien && this.hours==e.time ? true :false
  }

  // passerentretien(c:any){
  //   console.log("heure",this.date.getHours())
  //  this.disable=false;
  //  return   c.heure==this.date.getHours() && c.date==this.dateNow? true:false
  // }

}
