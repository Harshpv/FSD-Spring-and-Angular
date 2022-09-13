import { Component, OnInit } from '@angular/core';
import { Allitems } from '../Items/allitems';
import { Cart } from '../Items/cart.model';
import { Menu } from '../Items/menu.model';
import { ApiserviceService } from '../menuapiservice/apiservice.service';
import { CartService } from '../menuapiservice/cart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  message:any;


  itemList ! :any;
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
     console.log(this.itemList);
     
   })
   
   

 }
 tempdata : Cart={
   userEmailId : "karthiga@gmail.com",
   items: []
   
 }
 tempItem: Menu = { 
   itemId: 1,
   itemName: "",
   itemDescription: " ",
   category: "",
   itemCost:0,
   itemImage: "",

   quantity : 1,
 };
 public additems(menuitem:Allitems){
   // this.cart.menu.push(newitem)
   this.tempItem.itemId = menuitem.itemId, 
   this.tempItem.itemName =menuitem.itemName,
   this.tempItem.itemDescription =menuitem.itemDescription,
   this.tempItem.itemCost=menuitem.itemCost,
   this.tempItem.itemImage=menuitem.itemImage,
   this.tempItem.category =menuitem.category,
   this.tempItem.quantity = 1

   this.tempdata.items.push(this.tempItem)
  
   this.api.updateItems(this.tempdata).subscribe((data) => this.message=data)
   console.log(this.message);
   
   
 }
 
 
 


//   addItemsToCart(newitem:any){
// this.tempdata.menu.push(newitem)

//     this.api.updateItems(this.tempdata).subscribe((data)=>{
//       console.log(data)
//     })
   // this.tempdata.menu.push(newitem)

 // }

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
