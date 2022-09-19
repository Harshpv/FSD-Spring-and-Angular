import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class RecommendationService {
  constructor(private http:HttpClient) { }

  url=environment.url
  getData()
  {
    let url=`${this.url}/userrecommendation/api/v4/getdata`;
    return this.http.get(url);
  }

  getDataByCity(city:any){
    let url=`${this.url}/userrecommendation/api/v4/bycity/`+city;
    return this.http.get(url);
  }

}
