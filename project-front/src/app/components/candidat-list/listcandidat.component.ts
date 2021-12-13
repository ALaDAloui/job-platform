import { CandidatService } from './../../services/candidat.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listcandidat',
  templateUrl: './listcandidat.component.html',
  styleUrls: ['./listcandidat.component.css']
})
export class ListcandidatComponent implements OnInit {

  listcandidat:any


  constructor(private candidatService : CandidatService,
    private router: Router,) { }


  ngOnInit(): void {
    this.getCandidat()
  }

  getCandidat(){
    this.candidatService.getcandidat().subscribe((res:any)=>{
      this.listcandidat =res
      console.log("list of candidats",this.listcandidat)
  })
  }
}
