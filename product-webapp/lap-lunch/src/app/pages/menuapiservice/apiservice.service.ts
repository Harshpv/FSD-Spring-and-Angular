import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
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
  url=environment.url
  getItem(): Observable<Allitems[]> {
    return this.http.get<Allitems[]>(`${this.url}/menuuser/api/v1/getall`);
  }


  updateItems(cart: Cart): Observable<Cart> {
    return this.http.post<Cart>(
      `${this.url}/menuuser/api/v1/updateitems`,
      cart
    );
  }
  getallitems(): Observable<Cart> {
    return this.http
      .get<Cart>(`${this.url}/menuuser/api/v1/getallitems`)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
  emptyCart(): Observable<Cart> {
    return this.http.delete<Cart>(
      `${this.url}/menuuser/api/v1/emptycart`
    );
  }
}
