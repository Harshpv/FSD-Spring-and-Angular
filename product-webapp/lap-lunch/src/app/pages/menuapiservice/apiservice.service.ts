import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import {map} from "rxjs/operators"
import { Allitems } from '../Items/allitems';
import { Cart } from '../Items/cart.model';
import { Timetablemodel } from '../timetable/timetablemodel';
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
    return this.http.get<Allitems[]>("http://localhost:8085/api/v1/getall");
  }

  //api for timetable post
  postItemsToTimetable(timetablelist:Timetablemodel): Observable<Timetablemodel>{
    return this.http.post<Timetablemodel>("http://localhost:8086/api/v2",timetablelist);
  }
  //api for getting timetable 
  getTimeTable():Observable<any>{
    return this.http.get<any>("http://localhost:8086/api/v2");
  }
// delete data from timetable
deleteTimeTableData(id:any,index :any):Observable<any>{
  return this.http.delete<any>("http://localhost:8086/api/v2/"+id+"/"+index)
}
//Update items in time table
// updateTimeTableData(id:any):Observable<Timetablemodel>{
//   return this.http.put<Timetablemodel>("http://localhost:8086/api/v2/")
// }


  updateItems(cart:Cart): Observable<Cart>{
    return this.http.post<Cart>("http://localhost:8083/api/v1/cart/create",cart);
  }
  getallitems():Observable<Cart>{
    return this.http.get<Cart>("http://localhost:8083/api/v1/cart/karthiga@gmail.com");
  }
  emptyCart():Observable<Cart>{
    return this.http.delete<Cart>("http://localhost:8083/api/v1/cart/karthiga@gmail.com");
  }
  }
     
  