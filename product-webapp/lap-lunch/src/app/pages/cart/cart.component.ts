import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { Allitems } from '../Items/allitems';

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
  
  menuproduct !: Cart;
  product ! : Cart;
  public totalAmount !:number;
  Quantity:number =1;
  menu: any;
 


  constructor(private cartService: CartService,private api: ApiserviceService) { }
message : boolean =false;

  ngOnInit(): void {
   
   
     
      this.api.getallitems().subscribe((data) => 
      {
      this.menuproduct=data
      })}


  removeItem(index: any){
    this.product.items = index.pop();
    this.api.updateItems(this.product).subscribe((data) => this.product=data)
    console.log(this.product);

  }

  emptycart(){
    this.product.items = [];
    this.api.updateItems(this.product).subscribe((data) => this.product=data)
    console.log(this.product);
  }
  getTotalAmount(): number{
    let total = 0;
    for (var i = 0; i < this.product.items.length; i++) {
        if (this.product.items[i].itemCost) {
          total += this.product.items[i].itemCost * this.product.items[i].quantity;
            this.totalAmount = total;
        }
    }
    return total;
}


inc(index:number){
  if(this.product.items[index].quantity+1 < 1){
    this.product.items[index].quantity = 1;
    console.log('item_1-> ' + this.product.items[index].quantity)
  }
  else{
    this.product.items[index].quantity += 1;
    console.log('item_2-> ' + index +  '  '+this.product.items[index].quantity);
  }
}

desc(index:number){
  
    /*. if item passed then item.qty. */
      if(this.product.items[index].quantity-1 < 1){
        this.product.items[index].quantity = 1;
        console.log('item_1-> ' + this.product.items[index].quantity)
      }
      else{
        this.product.items[index].quantity -= 1;
        console.log('item_2-> ' + index +  '  '+this.product.items[index].quantity);
      }
      }

}
