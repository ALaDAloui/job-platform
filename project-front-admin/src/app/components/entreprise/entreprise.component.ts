import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { interval, Subscription } from 'rxjs';
import { EntrepriseService } from 'src/app/services/entreprise.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-entreprise',
  templateUrl: './entreprise.component.html',
  styleUrls: ['./entreprise.component.css']
})
export class EntrepriseComponent implements OnInit {

  listEntreprise:any

  private updateSubscription: Subscription;

  constructor(private entrepriseService : EntrepriseService,
    private router: Router,) { }

  ngOnInit(): void {
    this.getEntreprise()
  }


  getEntreprise(){
    this.entrepriseService.getEntreprise().subscribe((res:any)=>{
      this.listEntreprise =res
      console.log("list of entreprises",this.listEntreprise)
  })
  }

  updateEtat1(id:any){
    this.entrepriseService.etatEntreprie1(id).subscribe((res:any)=>{
   Swal.fire("Entreprise valider")
   window.location.href="http://localhost:3000/home/entreprise"
   this.updateSubscription = interval(1000).subscribe(
    (val) => {
  }
)
      console.log("Entreprise",res)
      // window.location.href="http://localhost:4200/listcandidature/29"
  })
  }

  updateEtat2(id:any){
    this.entrepriseService.etatEntreprie2(id).subscribe((res:any)=>{
   Swal.fire("Entreprise refuser")
      console.log("Entreprise",res)
  })
  }


  deleteEntreprise(id: any){
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
        this.entrepriseService.deleteEntreprise(id).subscribe( data => {
        Swal.fire(
          'Supprimer!',
          'Ce compte est bien supprimé.',
          'success'
        )
      })
    }
    // console.log(data);
    // this.listproduct();

})



}
}
