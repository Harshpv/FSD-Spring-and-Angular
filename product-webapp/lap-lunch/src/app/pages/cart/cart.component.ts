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
      console.log(this.menuproduct);
      
      })}

      


  removeItem(index: any){
    this.menuproduct.items.splice(index,1)
    this.api.updateItems(this.menuproduct).subscribe((data) => this.product=data)
    console.log(this.menuproduct);

  }

  emptycart(){
    this.menuproduct.items = [];
    this.api.updateItems(this.menuproduct).subscribe((data) => this.menuproduct=data)
    console.log(this.menuproduct);
  }
  getTotalAmount(): number{
    let total = 0;
    for (var i = 0; i < this.menuproduct.items.length; i++) {
        if (this.menuproduct.items[i].itemCost) {
          total += this.menuproduct.items[i].itemCost * this.menuproduct.items[i].quantity;
            this.totalAmount = total;
        }
    }
    return total;
}


inc(index:number){
  if(this.menuproduct.items[index].quantity+1 < 1){
    this.menuproduct.items[index].quantity = 1;
    console.log('item_1-> ' + this.product.items[index].quantity)
  }
  else{
    this.menuproduct.items[index].quantity += 1;
    console.log('item_2-> ' + index +  '  '+this.product.items[index].quantity);
  }
}

desc(index:number){
  
    /*. if item passed then item.qty. */
      if(this.menuproduct.items[index].quantity-1 < 1){
        this.menuproduct.items[index].quantity = 1;
        console.log('item_1-> ' + this.menuproduct.items[index].quantity)
      }
      else{
        this.menuproduct.items[index].quantity -= 1;
        console.log('item_2-> ' + index +  '  '+this.menuproduct.items[index].quantity);
      }
      }

}
