import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-searchheader',
  templateUrl: './searchheader.component.html',
  styleUrls: ['./searchheader.component.css']
})
export class SearchheaderComponent implements OnInit {
  
  public searchvalue: string='';
  constructor() { }

  ngOnInit(): void {
  }
  // search(event:any){
  //   this.searchvalue=(event.target as HTMLInputElement).value;
  //   console.log(this.searchvalue);}
}
 