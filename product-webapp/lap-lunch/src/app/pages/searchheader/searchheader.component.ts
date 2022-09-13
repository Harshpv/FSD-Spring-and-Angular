import { Component, OnInit } from '@angular/core';
import { Cart } from '../Items/cart.model';
import { ApiserviceService } from '../menuapiservice/apiservice.service';
import { CartService } from '../menuapiservice/cart.service';
import { Allitems } from '../Items/allitems';
import { filter } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-searchheader',
  templateUrl: './searchheader.component.html',
  styleUrls: ['./searchheader.component.css']
})
export class SearchheaderComponent implements OnInit {
  
  public searchvalue: string='';
  public itemscount : number =0;
  allitems!: Allitems[];
 searchItem:string='';
  
  constructor(private apisearchservice : ApiserviceService
   , private cartService: CartService, private route : ActivatedRoute ) { }

   ngOnInit(): void {
    // this.apisearchservice.getallitems()

    // .subscribe(res=>{
      // this.itemscount =this.apisearchservice.getallitems();
    }

  
  
   search(event:any){
     this.searchvalue=(event.target as HTMLInputElement).value;
    //  console.log(this.searchvalue);
     this.apisearchservice.search.next(this.searchvalue);
    
    }




}


 