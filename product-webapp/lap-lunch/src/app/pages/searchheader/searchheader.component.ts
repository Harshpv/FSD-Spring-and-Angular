import { Component, OnInit } from '@angular/core';
import { ApiserviceService } from '../menuapiservice/apiservice.service';

@Component({
  selector: 'app-searchheader',
  templateUrl: './searchheader.component.html',
  styleUrls: ['./searchheader.component.css']
})
export class SearchheaderComponent implements OnInit {
  
  public searchvalue: string='';
  
  constructor(private apisearchservice : ApiserviceService
    ) { }

  ngOnInit(): void {
  }
   search(event:any){
     this.searchvalue=(event.target as HTMLInputElement).value;
     console.log(this.searchvalue);
     this.apisearchservice.search.next(this.searchvalue);
    
    }
}
 