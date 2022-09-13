import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProfilepageService {
  constructor(private http: HttpClient) {}

  getAddressesById(id: string) {
    return this.http
      .get<any>('http://localhost:8080/api/v1/getUser/' + id)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  updateAddressById(id: string, userData: any) {
    return this.http
      .put<any>('http://localhost:8080/api/v1/updateUser/' + id, userData)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
}
