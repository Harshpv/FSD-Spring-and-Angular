import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProfileServiceService {
  constructor(private http: HttpClient) {}
  getOrders() {
    return this.http.get<any>('http://localhost:8081/api/v1/getOrders').pipe(
      map((res: any) => {
        return res;
      })
    );
  }
}
