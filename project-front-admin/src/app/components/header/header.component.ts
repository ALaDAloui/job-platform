import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})


export class HeaderComponent implements OnInit {

  userconnect=JSON.parse(localStorage.getItem("userconnect")!)

  constructor(private route:Router, ) { }

  ngOnInit(): void {


    console.log("id userconnect",this.userconnect.id)

  }

  logout() {
    localStorage.clear()
 /// this.route.navigateByUrl('/')
 window.location.href="http://localhost:3000"
 }

}
