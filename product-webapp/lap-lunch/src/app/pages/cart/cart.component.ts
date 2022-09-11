import { Component, OnInit } from '@angular/core';
import { CartService } from '../menuapiservice/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public product : any =[];
  public totalAmount !:number;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.cartService.getItems()
    .subscribe(res=>{
      this.product=res;
      this.totalAmount=this.cartService.getTotalAmount();
    })

  }

  removeItem(item: any){
    this.cartService.removeCartItem(item);
  }

  emptycart(){
    this.cartService.removeFUllCartItems();
  }



}
