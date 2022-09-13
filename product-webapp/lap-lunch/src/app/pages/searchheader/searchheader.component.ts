import { Component, OnInit } from '@angular/core';
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
    // this.cartService.getItems()
    // .subscribe((res: string | any[])=>{
    //   this.itemscount = res.length;
    // })

    // this.route.params.subscribe(params=>{
    //   if(params['searchItem'])

    //   this.allitems=this.cartService.getItems().filter((allitem: { itemName: string; })=>allitem.itemName.toLowerCase().includes(params['searchItem'].toLowerCase()));

    //   else
    //   this.allitems =this.cartService.getItems();

    // })

    this.route.params.subscribe(params=>{
      if(params['searchItem'])
      this.searchItem=params['searchItem'];
    })

  }
  
   search(event:any){
     this.searchvalue=(event.target as HTMLInputElement).value;
    //  console.log(this.searchvalue);
     this.apisearchservice.search.next(this.searchvalue);
    
    }




}


 