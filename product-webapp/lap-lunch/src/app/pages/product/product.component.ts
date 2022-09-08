import { ReturnStatement } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Allitems } from '../Items/allitems';
import { ApiserviceService } from '../menuapiservice/apiservice.service';
import { CartService } from '../menuapiservice/cart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public itemList :any;
  searchKey : string="";
  public filterCategory: any;
  constructor(private api: ApiserviceService, private cartService: CartService) { }

  ngOnInit(): void {
    this.api.getItem()
    .subscribe(res=>{
      this.itemList =res;
      this.filterCategory=res;

      this.itemList.forEach((a:any)=>{
        // if(a.category==="veg"){
        //   a.category="Veg Items"
      
        // }

        Object.assign(a,{quantity:1,total:a.itemCost});
      });
      // console.log(this.itemList);
      
    })
    
    this.api.search.subscribe((val:any)=>{
      this.searchKey=val;
    })
  }

  addItemsToCart(item:any){

    this.cartService.addItemtocart(item);

  }

  // ngOnInit(): void {
  //     this.api.getItem().subscribe((data: Allitems[])=>{
  //       console.log(data);
  // //      this.filterCategory=data;
  //       this.items=data;
  //     });
  // }

  filter(category:string){
    this.filterCategory=this.itemList
    .filter((a:any)=>{
      if(a.category==category||category==''){
        return a;
      }
    })}
}
