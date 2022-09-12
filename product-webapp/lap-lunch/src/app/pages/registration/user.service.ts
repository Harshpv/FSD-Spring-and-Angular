import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Allitems } from '../Items/allitems';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUser(): Observable<User[]>{
    return this.http.get<User[]>("http://localhost:8080/api/v1");
  }

  addUser(user : any): Observable<User> {
    return this.http.post<User>("http://localhost:8080/api/v1", user);
  }
}
