import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class RecommendationService {
  constructor(private http:HttpClient) { }

  getData()
  {
    let url="http://localhost:8282/api/v4/city/Banglore";
    return this.http.get(url);
  }


}
