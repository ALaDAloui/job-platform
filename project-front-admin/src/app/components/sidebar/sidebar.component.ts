import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

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
