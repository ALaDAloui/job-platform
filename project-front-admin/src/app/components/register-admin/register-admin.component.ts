import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {

  RegisterForm: FormGroup;
  submitted = false;

  fileToUpload:Array<File>=[];


  constructor(private formBuilder: FormBuilder,private route:Router, private apidata:LoginService,
    ) { }
  ngOnInit(): void {


    this.RegisterForm = this.formBuilder.group({
      email: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
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
    formdata.append("email",this.RegisterForm.value.email);
    formdata.append("password",this.RegisterForm.value.password);
    formdata.append("firstName",this.RegisterForm.value.firstName);
    formdata.append("lastName",this.RegisterForm.value.lastName);
    formdata.append("username",this.RegisterForm.value.username);
    formdata.append("file",this.fileToUpload[0]);
    // display form values on success
    this.apidata.registeradmistrateur(
      formdata).subscribe(res=>{
      console.log(res)
      Swal.fire(
        'Nouveau admin ajouté !',
        'success'
      )
      this.route.navigateByUrl('/')
     })
    }


}
