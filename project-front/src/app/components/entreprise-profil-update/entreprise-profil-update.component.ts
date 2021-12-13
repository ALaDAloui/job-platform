import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { EntrepriseService } from 'src/app/services/entreprise.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-entreprise-profil-update',
  templateUrl: './entreprise-profil-update.component.html',
  styleUrls: ['./entreprise-profil-update.component.css']
})
export class EntrepriseProfilUpdateComponent implements OnInit {

  fileToUpload:Array<File>=[];
  submitted = false;

  entrepriseUpdateForm: FormGroup;
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)
  constructor(private entrepriseService : EntrepriseService,
    private router: Router, private activeroute:ActivatedRoute,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.entrepriseUpdateForm = this.formBuilder.group({
      id: ['', Validators.required],
      nom_entreprise: ['', Validators.required],
      anneeCreation: ['', Validators.required],
      adresse: ['', Validators.required],
      siteWeb: ['', Validators.required],
      sect_activite: ['', Validators.required],
      description: ['', Validators.required],
      region: ['', Validators.required],
      telephone: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
      role: ['', Validators.required],
      image: ['', Validators.required],
      fblink: ['', Validators.required],
      instalink: ['', Validators.required],
      linkedlink: ['', Validators.required],
      twitterlink: ['', Validators.required],
      authorities: ['', Validators.required],

  }  );

    console.log("authorities", this.userconnect.authorities[0].authority)
  }
  updateentreprise(){
    // this.entrepriseUpdateForm.patchValue({
    //   password:this.userconnect.password,
    //   nom_entreprise:this.userconnect.nom_entreprise,
    //   username:this.userconnect.username,
    //   role:this.userconnect.role,
    //   image:this.userconnect.image,
    //   authorities:this.userconnect.authorities[0].authority,






    // })
    // console.log("id entteprise",this.entrepriseUpdateForm.value.id)
    this.entrepriseService.putDescription(this.userconnect.id,this.entrepriseUpdateForm.value.description).subscribe(res=>{
      console.log(res,"update offre")
      Swal.fire(
        'Profil modifié!',
        '',
        'success'
      )

     })
  }

  handleFileInput(files: any){
    this.fileToUpload=<Array<File>>files.target.files;
    console.log(this.fileToUpload);
  }
  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    // if (this.RegisterForm.invalid) {
    //   console.log("err de validation",this.RegisterForm.value)
    //     return;
    // }
    let formdata=new FormData();
    formdata.append("file",this.fileToUpload[0]);
    // display form values on success
    this.entrepriseService.updateImage(this.userconnect.id,
      formdata).subscribe(res=>{
      console.log(res)
      Swal.fire(
        'user added !',
        'success'
      )
      // this.route.navigateByUrl('/login')
     })
    }
  // updateImage(){
  //   // console.log("id entteprise",this.entrepriseUpdateForm.value.id)
  //   this.entrepriseService.updateImage(this.userconnect.id,this.entrepriseUpdateForm.value).subscribe(res=>{
  //     console.log(res,"update offre")
  //     Swal.fire(
  //       'OFFRE UPDATE!',
  //       'Your OFFRE has been updated.',
  //       'success'
  //     )

  //    })
  // }
}
