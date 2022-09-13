import { Component, OnInit } from '@angular/core';
import { Cart } from '../Items/cart.model';
import { ApiserviceService } from '../menuapiservice/apiservice.service';
import { CartService } from '../menuapiservice/cart.service';

@Component({
  selector: 'app-searchheader',
  templateUrl: './searchheader.component.html',
  styleUrls: ['./searchheader.component.css']
})
export class SearchheaderComponent implements OnInit {
  
  public searchvalue: string='';
   itemscount : number =0;
   items ! : Cart;
  
  constructor(private apisearchservice : ApiserviceService
   , private cartService: CartService ) { }

   ngOnInit(): void {
    
    
      this.apisearchservice.getallitems().
      subscribe((data) =>
      { this.items=data;})
      // this.itemscount = this.items.length;

       };
    
  
   search(event:any){
     this.searchvalue=(event.target as HTMLInputElement).value;
     console.log(this.searchvalue);
     this.apisearchservice.search.next(this.searchvalue);
    
    }
}
 