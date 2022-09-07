import { ReturnStatement } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Allitems } from '../Items/allitems';
import { ApiserviceService } from '../menuapiservice/apiservice.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public itemList: Allitems[] = [];
  searchKey : string="";
  public filterCategory: any;
  constructor(private api: ApiserviceService) { }

  ngOnInit(): void {
    this.api.getItem()
    .subscribe(res=>{
      this.itemList =res;
      
    })
    
    this.api.search.subscribe((val:any)=>{
      this.searchKey=val;
    })
  }
  // ngOnInit(): void {
  //     this.api.getItem().subscribe((data: Allitems[])=>{
  //       console.log(data);
  // //      this.filterCategory=data;
  //       this.items=data;
  //     });
  // }

  // filter(category:string){
  //   this.filterCategory=this.items
  //   .filter((a:any)=>{
  //     if(a.category==category||category==''){
  //       ReturnStatement;
  //     }
  //   })}
}
