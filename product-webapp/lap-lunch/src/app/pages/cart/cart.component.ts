import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { OrderModel } from 'src/app/profilepage/orders/ordersmodel';
import { OrdersService } from 'src/app/profilepage/orders/ordersService';
import { ProfilepageService } from 'src/app/profilepage/profilepageService';
import { addressModel, userModel } from 'src/app/profilepage/usermodel';
import { Allitems } from '../Items/allitems';

import { Cart } from '../Items/cart.model';
import { Menu } from '../Items/menu.model';
import { ApiserviceService } from '../menuapiservice/apiservice.service';

import { CartService } from '../menuapiservice/cart.service';
import { Order, orderMenu } from './OrderModel';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  menuproduct!: Cart;
  product!: Cart;
  public totalAmount!: number;
  Quantity: number = 1;
  menu: any;

  // address popup
  userEmailId: any = sessionStorage.getItem('emailId');
  userData: userModel = new userModel();
  addressList: addressModel[] = [];
  selectedindex: number = -1;
  newOrder: Order = new Order();
  itemsList: orderMenu[] = [];
  newItem: orderMenu = new orderMenu();

  constructor(
    private cartService: CartService,
    private api: ApiserviceService,
    private profileApi: ProfilepageService,
    private ordersApi: OrdersService
  ) {}
  message: boolean = false;

  ngOnInit(): void {
    this.api.getallitems().subscribe((data) => {
      this.menuproduct = data;
      console.log(this.menuproduct);
    });
    this.getAllByUserEmailId(); //for displaying all addresses
  }

  removeItem(index: any) {
    this.menuproduct.items.splice(index, 1);
    this.api
      .updateItems(this.menuproduct)
      .subscribe((data) => (this.product = data));
    console.log(this.menuproduct);
  }

  emptycart() {
    this.menuproduct.items = [];
    this.api
      .updateItems(this.menuproduct)
      .subscribe((data) => (this.menuproduct = data));
    console.log(this.menuproduct);
  }
  getTotalAmount(): number {
    let total = 0;
    for (var i = 0; i < this.menuproduct.items.length; i++) {
      if (this.menuproduct.items[i].itemCost) {
        total +=
          this.menuproduct.items[i].itemCost *
          this.menuproduct.items[i].quantity;
        this.totalAmount = total;
      }
    }
    return total;
  }

  inc(index: number) {
    if (this.menuproduct.items[index].quantity + 1 < 1) {
      this.menuproduct.items[index].quantity = 1;
      console.log('item_1-> ' + this.product.items[index].quantity);
    } else {
      this.menuproduct.items[index].quantity += 1;
      console.log(
        'item_2-> ' + index + '  ' + this.product.items[index].quantity
      );
    }
  }

  desc(index: number) {
    /*. if item passed then item.qty. */
    if (this.menuproduct.items[index].quantity - 1 < 1) {
      this.menuproduct.items[index].quantity = 1;
      console.log('item_1-> ' + this.menuproduct.items[index].quantity);
    } else {
      this.menuproduct.items[index].quantity -= 1;
      console.log(
        'item_2-> ' + index + '  ' + this.menuproduct.items[index].quantity
      );
    }
  }

  // Address popup part-----

  getAllByUserEmailId() {
    this.profileApi.getAddressesById(this.userEmailId).subscribe((res) => {
      this.userData = res;
      this.addressList = this.userData.address;
      console.log(this.addressList);
    });
  }

  addressclick(index: number) {
    this.selectedindex = index;
  }
  createNewOrder() {
    this.newOrder.userEmailId = this.userEmailId;
    this.menuproduct.items.forEach((item) => {
      this.newItem.itemId = item.itemId!;
      this.newItem.itemName = item.itemName!;
      this.newItem.itemDescription = item.itemDescription!;
      this.newItem.qty = item.quantity;
      this.newItem.itemCost = item.itemCost;
      this.newItem.image = item.itemImage!;
      this.itemsList.push(this.newItem);
    });
    this.newOrder.itemsList = this.itemsList;
    this.newOrder.address = this.addressList[this.selectedindex];
    console.log(this.newOrder);
    // console.log(this.newOrder);
    this.ordersApi.createOrderforUser(this.newOrder).subscribe((res) => {
      console.log(res);
    });
  }
}
