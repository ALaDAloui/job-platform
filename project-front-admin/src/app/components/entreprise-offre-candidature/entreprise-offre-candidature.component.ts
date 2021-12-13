import { Subscription } from 'rxjs';
import { CandidatureService } from './../../services/candidature.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-entreprise-offre-candidature',
  templateUrl: './entreprise-offre-candidature.component.html',
  styleUrls: ['./entreprise-offre-candidature.component.css']
})
export class EntrepriseOffreCandidatureComponent implements OnInit {

  listcandidature: any
  id=this.activeroute.snapshot.params.id
  offre:any
  private updateSubscription: Subscription;

  constructor( private candidatureService: CandidatureService , private activeroute:ActivatedRoute, private router: Router,) { }

  ngOnInit(): void {

    this.getCandidatureByOffre()

  }


  getCandidatureByOffre(){
    this.candidatureService.getCandidature(this.id).subscribe((res:any)=>{
      this.listcandidature=res
      this.offre=res
      console.log("list of candidature",this.listcandidature)
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
        this.candidatureService.deleteCandidature(id).subscribe( data => {
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
