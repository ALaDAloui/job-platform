import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute, RouterLink } from '@angular/router';
import { OffreService } from './../../services/offre.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-offre-detail',
  templateUrl: './offre-detail.component.html',
  styleUrls: ['./offre-detail.component.css']
})
export class OffreDetailComponent implements OnInit {

  show_coor2=false
  ecommentaire:any=[]
  //candidatureForm: FormGroup;

  detailoffre:any
  id=this.activeroute.snapshot.params.id
  offre:any
  id1:any
idcomment:any
  closeResult = '';
  commentaireForm: FormGroup;
  submitted = false;


  listreponse:any
  listcommentaire:any
  fileToUpload:Array<File>=[];
list:any
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private modalService: NgbModal ,private formBuilder: FormBuilder, private offreService : OffreService,
    private router: Router,private activeroute:ActivatedRoute,private apidata:OffreService) { }

  ngOnInit(): void {
    this.getOffre()


// this.getreponse()
    // console.log("id user",this.userconnect.id)
     this.getCommentaireByOffre()

    this.commentaireForm =this.formBuilder.group({
      contenu: ['', Validators.required],
    }, )

    console.log("id userconnect",this.userconnect.id)

  //   this.candidatureForm = this.formBuilder.group({
  //     id: ['', Validators.required],
  //     email: ['', Validators.required],
  //     Offre_ID: ['', Validators.required],
  //     Candidat_ID: ['', Validators.required],
  //     etat: ['', Validators.required],



  // }  );
  }

  // verif(id:any){
  //   this.offreService.getReponse(id).subscribe((res:any)=>{
  //     this.listreponse=res
  //     console.log("list of reponse",this.listreponse)
  // })
  // }

  showcord2(id:any,index:any){
    this.show_coor2=true
    this.id1=id



  }



  // get f() { return this.candidatureForm.controls; }
  // handleFileInput(files: any){
  //   this.fileToUpload=<Array<File>>files.target.files;
  //   console.log(this.fileToUpload);
  // }

  // addCandidature() {
  //   this.submitted = true;
  //   // stop here if form is invalid
  //   // if (this.RegisterForm.invalid) {
  //   //   console.log("err de validation",this.RegisterForm.value)
  //   //     return;
  //   // }
  //   let formdata=new FormData();
  //   formdata.append("email",this.candidatureForm.value.email);
  //   formdata.append("Offre_ID",this.candidatureForm.value.Offre_ID);
  //   formdata.append("Candidat_ID",this.candidatureForm.value.Candidat_ID);
  //   formdata.append("file",this.fileToUpload[0]);
  //   formdata.append("etat","en cours");

  //   // display form values on success
  //   console.log("id user",this.userconnect.id)
  //   this.offreService.createCandidature(
  //     formdata,this.id,163843).subscribe(res=>{
  //     console.log(res)
  //     Swal.fire(
  //       'user added !',
  //       'success'
  //     )
  //     // this.router.navigateByUrl('/login')
  //    })
  //   }
  // addCandidature1(){
  //   this.offreService.createCandidature(this.candidatureForm.value,this.candidatureForm.value.id,this.candidatureForm.value.id).subscribe(res=>{
  //     console.log(res,"create  candidature")
  //     Swal.fire(
  //       'candidature crée!',
  //       'Ta candidature est bien enregistrer.',
  //       'success'
  //     )

  //    })
  // }
  // open(content:any) {
  //   this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
  //     this.closeResult = `Closed with: ${result}`;
  //   }, (reason) => {
  //     this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  //   });
  // }
  // private getDismissReason(reason: any): string {
  //   if (reason === ModalDismissReasons.ESC) {
  //     return 'by pressing ESC';
  //   } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
  //     return 'by clicking on a backdrop';
  //   } else {
  //     return `with: ${reason}`;
  //   }
  // }

  getOffre(){
    this.offreService.getOneOffre(this.id).subscribe((res:any)=>{
      this.detailoffre =res
      this.offre=res
      console.log("get OFFRE by id",this.detailoffre)
  })
  }
  // getreponse(){
  //   this.offreService.getReponse(this.idcomment).subscribe((res:any)=>{
  //     this.list =res
  //     // this.offre=res
  //     console.log("get rep by id",this.list)
  // })
  // }
  isconnect(){
    if(localStorage.getItem('state')=="0"){
      // this.router.navigateByUrl(['/candidatexamen',this.id])
      this.router.navigateByUrl(`/candidatexamen/${this.id}`)
    }
    else{
      this.router.navigateByUrl("/login")
    }
    }

//commentaire

  getCommentaireByOffre(){

    this.offreService.getCommentaire(this.id).subscribe((res:any)=>{
      this.listcommentaire=res
      this.ecommentaire=  this.listcommentaire
      console.log("list of commentaires",this.listcommentaire)



this.ecommentaire.forEach((element:any) => {
  this.offreService.getReponse(element.id).subscribe((res:any)=>{
    this.list =res
    console.log("get rep by id",this.list)
})
});
})
  }
  onSubmit() {
    this.submitted = true;

     this.offreService.createCommentaire(this.offre.id,this.userconnect.id,this.commentaireForm.value).subscribe((res:any)=>{
       this.getCommentaireByOffre()
     // Swal.fire('commentaire added')
    // display form values on success
    // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})
}

//reponse commentaire

// getReponseByComment(){

//   this.offreService.getReponse(this.commentaireForm.id).subscribe((res:any)=>{
//     this.listreponse=res
//     console.log("list of reponse",this.listreponse)
// })
// }

onSubmitRep(id:any) {
  this.submitted = true;
this.idcomment=id
   this.offreService.createReponse(id,this.userconnect.id,this.commentaireForm.value).subscribe((res:any)=>{
     console.log("reponse",res)
     this.offreService.getReponse(this.idcomment).subscribe((res:any)=>{
      this.list =res
      // this.offre=res
      console.log("get rep by id",this.list)
  })
    // Swal.fire('commentaire added')
  // display form values on success
  // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})
}





}
