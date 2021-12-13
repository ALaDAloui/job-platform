import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ExamenService } from './../../../services/examen.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-examen',
  templateUrl: './add-examen.component.html',
  styleUrls: ['./add-examen.component.css']
})
export class AddExamenComponent implements OnInit {



  closeResult = '';
  ajoutexamenForm: FormGroup;
  submitted = false;
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private examenService : ExamenService, private formBuilder: FormBuilder,private route:Router, private apidata:ExamenService) { }

  ngOnInit(): void {

    this.ajoutexamenForm = this.formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      maxMarks: ['', Validators.required],
      numberOfQuestions: ['', Validators.required],
  }  );
  }


  get f() { return this.ajoutexamenForm.controls; }



onSubmit() {
  this.submitted = true;

   this.examenService.createExamen(this.userconnect.id,this.ajoutexamenForm.value.id,this.ajoutexamenForm.value).subscribe((res:any)=>{
    Swal.fire('offre added')
    console.log("offre",res)
    this.route.navigateByUrl('/entrepriseoffre')

  // display form values on success
  // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.productForm.value, null, 4));
})


}

}
