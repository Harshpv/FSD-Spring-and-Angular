import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OrdersService {
  constructor(private http: HttpClient) {}
  getOrdersByemailId(userEmailId: string) {
    return this.http
      .get<any>('http://localhost:8083/api/v1/getOrders/' + userEmailId)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  createOrderforUser(orderData: any) {
    return this.http
      .post<any>('http://localhost:8083/api/v1/addOrder', orderData)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
}
