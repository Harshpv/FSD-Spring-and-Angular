import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Allitems } from '../Items/allitems';
import { Cart } from '../Items/cart.model';
@Injectable({
  providedIn: 'root',
})
export class ApiserviceService {
  public search = new BehaviorSubject<string>('');

  constructor(private http: HttpClient) {}

  // getItem(){
  //   return this.http.get<Allitems[]>(" http://localhost:8081/api/v1/getall")
  //   .pipe(map((res:any)=>{
  //     return res;
  //   }));
  getItem(): Observable<Allitems[]> {
    return this.http.get<Allitems[]>('http://localhost:8085/api/v1/getall');
  }

  updateItems(cart: Cart): Observable<Cart> {
    return this.http.post<Cart>(
      'http://localhost:8083/api/v1/cart/create',
      cart
    );
  }
  getallitems(): Observable<Cart> {
    return this.http
      .get<Cart>('http://localhost:8083/api/v1/cart/karthiga@gmail.com')
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
  emptyCart(): Observable<Cart> {
    return this.http.delete<Cart>(
      'http://localhost:8083/api/v1/cart/karthiga@gmail.com'
    );
  }
}
