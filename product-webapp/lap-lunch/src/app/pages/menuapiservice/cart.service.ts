import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartList : any=[];
  public menuList = new BehaviorSubject<any>([]);
  constructor() { }

  getItems(){
   return this.menuList.asObservable();
  }

  setItems(newitem : any){
    this.cartList.push(...newitem);
    this.menuList.next(newitem);
  }

  addItemtocart(newitem: any){
    this.cartList.push(newitem);
    this.menuList.next(this.cartList);
    this.getTotalAmount();
    console.log(this.cartList);
  }

  getTotalAmount(): number{
    let totalAmount=0;
    this.cartList.map((a:any)=>{
      totalAmount +=a.total;
    })

    return totalAmount;
  }

  removeCartItem(newitem:any){
    this.cartList.map((a:any,index:any)=>{
      if(newitem.id === a.id){
        this.cartList.splice(index,1);
      }
    })
    this.menuList.next(this.cartList);
  }

  removeFUllCartItems(){
    this.cartList=[];
    this.menuList.next(this.cartList);
  }

}
