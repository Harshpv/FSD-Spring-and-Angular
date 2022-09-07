import { Component, OnInit } from '@angular/core';
import { ApiserviceService } from '../menuapiservice/apiservice.service';
import { CartService } from '../menuapiservice/cart.service';

@Component({
  selector: 'app-searchheader',
  templateUrl: './searchheader.component.html',
  styleUrls: ['./searchheader.component.css']
})
export class SearchheaderComponent implements OnInit {
  
  public searchvalue: string='';
  public itemscount : number =0;
 
  
  constructor(private apisearchservice : ApiserviceService
   , private cartService: CartService ) { }

   ngOnInit(): void {
    this.cartService.getItems()
    .subscribe(res=>{
      this.itemscount = res.length;
    })
  }
   search(event:any){
     this.searchvalue=(event.target as HTMLInputElement).value;
     console.log(this.searchvalue);
     this.apisearchservice.search.next(this.searchvalue);
    
    }
}
 