import { ActivatedRoute, Router } from '@angular/router';
import { CandidatService } from './../../services/candidat.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-candidat-detail',
  templateUrl: './candidat-detail.component.html',
  styleUrls: ['./candidat-detail.component.css']
})
export class CandidatDetailComponent implements OnInit {

  detailcandidat:any
  id=this.activeroute.snapshot.params.id
  condidat:any

  listexperience:any
  listformation:any

  listcandidat:any
  constructor(private candidatService : CandidatService,
    private router: Router,private activeroute:ActivatedRoute) { }

    ngOnInit(): void {
      this.getCandidat()
      this.getExperienceByUser()
      this.getFormationByUser()
      this.getOtherCandidat()
    }

    getCandidat(){
      this.candidatService.getOneCandidat(this.id).subscribe((res:any)=>{
        this.detailcandidat =res
        this.condidat=res
        console.log("get condidat by id",this.detailcandidat)
    })
    }
    getOtherCandidat(){
      this.candidatService.getcandidat().subscribe((res:any)=>{
        this.listcandidat =res
        console.log("list of candidats",this.listcandidat)
    })
    }

    getExperienceByUser(){
      this.candidatService.getExperience(this.id).subscribe((res:any)=>{
        this.listexperience=res
        console.log("list of experiencess",this.listexperience)
    })
    }
    getFormationByUser(){
      this.candidatService.getFormation(this.id).subscribe((res:any)=>{
        this.listformation=res
        console.log("list of formations",this.listformation)
    })
    }

}
