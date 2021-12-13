import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { CandidatService } from 'src/app/services/candidat.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-candidat-candidature',
  templateUrl: './candidat-candidature.component.html',
  styleUrls: ['./candidat-candidature.component.css']
})
export class CandidatCandidatureComponent implements OnInit {

  candidature:any

  listentretien:any


  listCandidature:any
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private modalService: NgbModal,private condidatservice:CandidatService , private router: Router,) { }

  ngOnInit(): void {

    this.getCandidatureByUser()

  }

  iscandidat(){
    return this.userconnect.role==="candidat" ? true :false
  }

  getCandidatureByUser(){
    this.condidatservice.getCandidature(this.userconnect.id).subscribe((res:any)=>{
      this.listCandidature=res
      console.log("list of experiencess",this.listCandidature)
  })
  }

  getEntretienByCandidature(){
    this.condidatservice.getEntretien(this.userconnect.id).subscribe((res:any)=>{
      this.listentretien=res
      console.log("list of entretien",this.listentretien)
  })
  }


  deleteCandidature(id: any){
    Swal.fire({
      title: 'Êtes vous sûrs??',
      text: "Vous ne pourrez pas revenir en arrière",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Oui, supprimer le!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.condidatservice.deleteCandidature(id).subscribe( data => {
        Swal.fire(
          'Supprimer!',
          'Loffre est bien supprimé.',
          'success'
        )
      })
    }
    // console.log(data);
    // this.listproduct();

})



}

}
