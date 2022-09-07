import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import {map} from "rxjs/operators"
import { Allitems } from '../Items/allitems';
@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {

  public search= new BehaviorSubject<string>("");

  constructor(private http: HttpClient) { }

  // getItem(){
  //   return this.http.get<Allitems[]>(" http://localhost:8081/api/v1/getall")
  //   .pipe(map((res:any)=>{
  //     return res;
  //   }));
  getItem(): Observable<Allitems[]>{
    return this.http.get<Allitems[]>("http://localhost:8080/api/v1/getall");
  }
  }    
  