import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { CategorieService } from './../../services/categorie.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css']
})
export class CategorieComponent implements OnInit {

  listcategorie: any

  closeResult = '';
  ajoutCategorieform: FormGroup;
  updateCategorieform:FormGroup
  submitted = false;

  constructor(private modalService: NgbModal, private formBuilder: FormBuilder , private categorieService: CategorieService ,private route: Router ) { }


  ngOnInit(): void {

    this.getCategorie()

    this.ajoutCategorieform = this.formBuilder.group({
      nom: ['', Validators.required],
}  );

  this.updateCategorieform = this.formBuilder.group({
    id: ['', Validators.required],
    nom: ['', Validators.required],
}  );


  }


  getCategorie(){
    this.categorieService.getCategorie().subscribe((res:any)=>{
      this.listcategorie =res
      console.log("list of categorie",this.listcategorie)
  })
  }

onSubmit() {
  this.submitted = true;

   this.categorieService.createCategorie(this.ajoutCategorieform.value).subscribe((res:any)=>{
    Swal.fire('Categorie ajoutée !  ')
    console.log("offre",res)
    this.route.navigateByUrl('/categorie')

    // display form values on success
  // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})


}

updatecategorie(){
  this.categorieService.updateCategorie(this.updateCategorieform.value.id,this.updateCategorieform.value).subscribe(res=>{
    console.log(res,"moifier categorie")
    Swal.fire(
      'Categorie Modifié!',
      'Your categorie has been updated.',
      'success'
    )

   })
}
open(content:any,categorie:any) {

  this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}
open1(content1:any,categorie:any) {

  this.updateCategorieform.setValue({
    id:categorie.id,
    nom:categorie.nom,
  })

  this.modalService.open(content1, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}

private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
  } else {
    return `with: ${reason}`;
  }
}

deleteCtegorie(id: any){
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
      this.categorieService.deleteCategorie(id).subscribe( data => {
      console.log("offre deleted",data)
      Swal.fire(
        'Supprimer!',
        'Cette categorie est bien supprimé.',
        'success'
      )
    })
  }
  // console.log(data);
  // this.listproduct();

})



}











}
