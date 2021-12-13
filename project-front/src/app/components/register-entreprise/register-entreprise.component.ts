import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register-entreprise',
  templateUrl: './register-entreprise.component.html',
  styleUrls: ['./register-entreprise.component.css']
})
export class RegisterEntrepriseComponent implements OnInit {

  RegisterForm: FormGroup;
  submitted = false;

  fileToUpload:Array<File>=[];
  constructor(private formBuilder: FormBuilder,private route:Router, private apidata:LoginService
    ) { }
  ngOnInit(): void {


    this.RegisterForm = this.formBuilder.group({
      nom_entreprise: ['', Validators.required],
     // anneeCreation: ['', Validators.required],
      adresse: ['', Validators.required],
      siteWeb: ['', Validators.required],
      region : ['', Validators.required],
      telephone: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      fblink: ['', Validators.required],
      instalink: ['', Validators.required],
      linkedlink: ['', Validators.required],
      twitterlink: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required] ,
  });
  }
  get f() { return this.RegisterForm.controls; }
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
    formdata.append("nom_entreprise",this.RegisterForm.value.nom_entreprise);
    formdata.append("password",this.RegisterForm.value.password);
    formdata.append("firstName",this.RegisterForm.value.firstName);
    formdata.append("lastName",this.RegisterForm.value.lastName);
    formdata.append("anneeCreation",this.RegisterForm.value.anneeCreation);
    formdata.append("adresse",this.RegisterForm.value.adresse);
    formdata.append("siteWeb",this.RegisterForm.value.siteWeb);
    formdata.append("region",this.RegisterForm.value.region);
    formdata.append("telephone",this.RegisterForm.value.telephone);
    formdata.append("username",this.RegisterForm.value.username);
    formdata.append("fblink",this.RegisterForm.value.fblink);
    formdata.append("instalink",this.RegisterForm.value.instalink);
    formdata.append("linkedlink",this.RegisterForm.value.linkedlink);
    formdata.append("twitterlink",this.RegisterForm.value.twitterlink);
    formdata.append("role","entreprise");

    formdata.append("file",this.fileToUpload[0]);
    // display form values on success
    this.apidata.registerentreprise(
      formdata).subscribe(res=>{
      console.log(res)
      Swal.fire(
        'user added !',
        'success'
      )
      this.route.navigateByUrl('')
     })
    }


}
