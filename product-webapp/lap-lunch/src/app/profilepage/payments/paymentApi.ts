import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { paymentModel } from './paymentModel';

@Injectable({
  providedIn: 'root',
})
export class paymentService {
  constructor(private http: HttpClient) {}

  createPayment(newPayment: any) {
    return this.http
      .post<any>('http://localhost:8080/api/v1/payNow', newPayment)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
  updatePayment(newPayment: any) {
    return this.http
      .put<any>('http://localhost:8080/api/v1/updatePayment', newPayment)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  getPaymentsByemailId(userEmailId: string) {
    return this.http
      .get<any>('http://localhost:8080/api/v1/getPayments/' + userEmailId)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
}
