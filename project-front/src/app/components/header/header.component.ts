import { NotificationService } from './../../services/notification.service';
import { environment } from './../../../environments/environment';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userconnect=JSON.parse(localStorage.getItem("userconnect")!)
  id=this.activeroute.snapshot.params.id

  listNOtification:any
  constructor(private notificationService:NotificationService , private http:HttpClient , private route : Router ,private activeroute:ActivatedRoute,private login:LoginService) { }

  ngOnInit(): void {

this.getNotification()

  }

  getNotification(){
    this.notificationService.getNotification().subscribe((res:any)=>{
      this.listNOtification=res.filter((el:any)=>el.ee.e.id==this.userconnect.id)
      console.log("list of notification",this.listNOtification)
  })
  }

  iscandidat(){
    return this.userconnect.role==="candidat" ? true :false
  }




  isentreprise(){
    return this.userconnect.role==="entreprise" ? true :false
  }

//   logout() {
//     localStorage.clear()
//   // this.route.navigateByUrl('/')
//  }
logout(){
  localStorage.clear()
 // this.route.navigateByUrl('/')
  window.location.href="http://localhost:4200"

//   this.login.logout().subscribe((res:any)=>{

//     console.log("logout succes")
//     this.route.navigateByUrl('/')
// })
}
 isconnect(){
  if(localStorage.getItem('state')=="0"){
    // this.router.navigateByUrl(['/candidatexamen',this.id])
    this.route.navigateByUrl(`/postuloffre`)
  }
  else{
    this.route.navigateByUrl("/login")
  }
  }

  isConnect2(){
    return localStorage.getItem('state') =="0" ? true :false
  }

}
