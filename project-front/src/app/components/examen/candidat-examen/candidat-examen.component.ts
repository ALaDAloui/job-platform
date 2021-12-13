import { OffreService } from './../../../services/offre.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ExamenService } from './../../../services/examen.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-candidat-examen',
  templateUrl: './candidat-examen.component.html',
  styleUrls: ['./candidat-examen.component.css']
})
export class CandidatExamenComponent implements OnInit {

  candidatureForm: FormGroup;
  submitted = false;
  fileToUpload:Array<File>=[];

  timeLeft: number = 30;
  timenumber:number=0;
  interval:any;

  listrandomExamen:any
  id=this.activeroute.snapshot.params.id
  idexamen:any
  offre:any

  show_coor2=false

  listQuestion:any
  examen:any

  // marksGot: any = 0;
  // correctAnswers: any = 0;
  // attempted: any = 0;
  // option1=''
   n:any=0
  // isSubmit = false;

  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private formBuilder: FormBuilder ,private examenService : ExamenService,private offreService : OffreService,
    private router: Router, private activeroute:ActivatedRoute) { }

  ngOnInit(): void {
    this.getRandomExam()

    // this.getQuestionExam()
    console.log("id user",this.userconnect.id)


    this.candidatureForm = this.formBuilder.group({
      id: ['', Validators.required],
      email: ['', Validators.required],
      Offre_ID: ['', Validators.required],
      Candidat_ID: ['', Validators.required],
      etat: ['', Validators.required],

  }  );
  }


  get f() { return this.candidatureForm.controls; }
  handleFileInput(files: any){
    this.fileToUpload=<Array<File>>files.target.files;
    console.log(this.fileToUpload);
  }


  getRandomExam(){
    this.examenService.getRandomExamenByOffres(this.id).subscribe((res:any)=>{
      this.listrandomExamen=res
      console.log("examen",this.listrandomExamen)
      console.log("id examen",this.listrandomExamen[0].exId)
      this.idexamen=this.listrandomExamen[0].exId
      this.examenService.getQuestionByExamen(this.idexamen).subscribe((res:any)=>{
        this.listQuestion=res
        this.examen=res
        console.log("question",this.listQuestion)
    })

  })
  }



  addCandidature() {
    this.submitted = true;
    let formdata=new FormData();
    formdata.append("email",this.candidatureForm.value.email);
    formdata.append("Offre_ID",this.candidatureForm.value.Offre_ID);
    formdata.append("Candidat_ID",this.candidatureForm.value.Candidat_ID);
    formdata.append("file",this.fileToUpload[0]);
    formdata.append("etat","en cours");
    formdata.append("note",this.n);


    // display form values on success
    console.log("id user",this.userconnect.id)
    this.offreService.createCandidature(
      formdata,this.id,this.userconnect.id).subscribe(res=>{
      console.log(res)
      Swal.fire(
        'Candidature enregistrée!',

      )
     // window.location.href="http://localhost/candidatureC"

      // this.router.navigateByUrl('/login')
     })
  }

  startTimer() {
    this.interval = setInterval(() => {
      if(this.timeLeft > 0) {
        this.timeLeft--;
      }
      else{
        if(this.timeLeft==0){
          Swal.fire({
          title:'duree expirée!'
        });
          this.addCandidature()
          this.pauseTimer()
          this.router.navigateByUrl('/')
        }
      }
    },1000)
  }
  pauseTimer() {
    clearInterval(this.interval);
  }







  onchange(e:any,answer:any){
    console.log("valeur",e.target.value)
    console.log("answer",answer)
       if(e.target.value.includes(answer)){
         //this.formdetail.value.note+=1;
        //  console.log("note",this.formdetail.value.note)
         this.n+=1;
         console.log("okkkk" ,this.n)
       }
       // else{
       //   Swal.fire({
       //     icon:'error',
       //     title:'Votre reponse est fausse!'
       //   });
       // }

     }




  showcord2(){
    this.show_coor2=true
    this.startTimer()

  }


  // getQuestionExam(){
  //   console.log("id examen",this.idexamen)
  //   this.examenService.getQuestionByExamen(this.idexamen).subscribe((res:any)=>{
  //     this.listQuestion=res
  //     this.examen=res
  //     console.log("question",this.listQuestion)
  // })
  // }



  // submitExam(){
  //   Swal.fire({
  //     title: 'Do you want to submit the exam?',
  //     showCancelButton: true,
  //     confirmButtonText: `Submit`,
  //     icon: 'info',
  //   }).then((e) => {
  //     if (e.isConfirmed) {
  //       this.evalExam();
  //       // this.user.obtMarks=this.marksGot;
  //       // this.submitMarks();
  //       // this.login.logout();
  //     }
  //   });
  // }


  // evalExam() {
  //   //calculation
  //   this.isSubmit = true;

  //   this.listQuestion.forEach((q: any) => {
  //     if (q.givenAnswer == q.answer) {
  //       this.correctAnswers++;
  //       let marksSingle =
  //         this.listQuestion[0].exam.maxMarks / this.listQuestion.length;
  //       this.marksGot += marksSingle;
  //     }
  //     console.log("note",this.marksGot)

  //     // if (q.givenAnswer.trim() != '') {
  //     //   this.attempted++;
  //     // }
  //   });



  // }



  // updateNote(){
  //   this.examenService.updateNote(this.id,this.note.value).subscribe(res=>{
  //     console.log(res,"update offre")


  //    })
  // }

    }
