import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';

import { Cart } from '../Items/cart.model';
import { Menu } from '../Items/menu.model';
import { ApiserviceService } from '../menuapiservice/apiservice.service';

import { CartService } from '../menuapiservice/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  
   product ! : Cart;
  public totalAmount !:number;
  Quantity:number =1;
  menu: any;
 


  constructor(private cartService: CartService,private api: ApiserviceService) { }
message : boolean =false;

  ngOnInit(): void {
   
   
     
      this.api.getallitems().subscribe((data) => 
      {
      this.product=data
    if(this.product.items.length==0){
      this.message=true;
    }
    },
      error =>{
        this.message=true;

      }
      
      
      )
    console.log(this.product);
    
    
     
   

  }
  



  removeItem(item: any){
    this.cartService.removeCartItem(item);

  }

  emptycart(){
    this.product.items = [];
    this.api.updateItems(this.product).subscribe((data) => this.product=data)
    console.log(this.product);
  }


inc(item:any){
this.cartService.IncrementItemQuantity(item);
}

desc(item:any){
  this.cartService.CartItemDecrement(item);

}}
