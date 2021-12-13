import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CandidatService } from 'src/app/services/candidat.service';

@Component({
  selector: 'app-candidat-entretien',
  templateUrl: './candidat-entretien.component.html',
  styleUrls: ['./candidat-entretien.component.css']
})
export class CandidatEntretienComponent implements OnInit {



  listentretien:any
  listentretienn:any
  date=new Date().toISOString().split('T')[0].toString()

  d = new Date();
  hours = this.d.getHours() ;

  userconnect=JSON.parse(localStorage.getItem("userconnect")!)
  constructor(private condidatservice:CandidatService , private router: Router) { }

  ngOnInit(): void {
    // this.getEntretienByUser()
    this.getAllEntretien()

  }

  getAllEntretien(){
    this.condidatservice.getEntretienn().subscribe((res:any)=>{
      this.listentretienn=res.filter((el:any)=>el.didature.ca.id==this.userconnect.id)
      console.log("list of all entretien",this.listentretienn)
  })
  }

  // getEntretienByUser(){
  //   this.condidatservice.getEntretien(this.userconnect.id).subscribe((res:any)=>{
  //     this.listentretien=res
  //     console.log("list of entretien",this.listentretien)
  // })
  // }

  // getEntretienByCandidature(){
  //   this.condidatservice.getEntretienbycandidature(this.userconnect.id).subscribe((res:any)=>{
  //     this.listentretien=res
  //     console.log("list of entretien",this.listentretien)
  // })
  // }

  passer(e:any){
    // && e.heure==
    console.log("heure",this.hours)
    return this.date==e.dateEntretien && this.hours==e.time ? true :false
  }
}
