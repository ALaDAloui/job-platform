import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pdf',
  templateUrl: './pdf.component.html',
  styleUrls: ['./pdf.component.css']
})
export class PdfComponent implements OnInit {
  id=this.activeroute.snapshot.params.id

  constructor(private activeroute:ActivatedRoute) { }
  ngOnInit(): void {
  }
  pdfSrc = "http://localhost:8085/users/filealltypes/"+this.id;


}
