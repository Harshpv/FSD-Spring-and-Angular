import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import { Login } from '../login';
import { User } from 'src/app/pages/registration/user.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
// import{router} from '.angular/router';
@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  token:any;
  decodedToken:any;

  helper= new JwtHelperService();
  constructor(private http:HttpClient,private jwtHelper :JwtHelperService, private router:Router) { }
  
  url=environment.url
  login(email:string, password:string )  {
    return this.http.post<Login>(`${this.url}/userauth/api/v1/login`, {email, password})
  }
  
  addUser(email:String, password:String){
    return this.http.post<Login>(`${this.url}/userauth/api/v1/adduser`,{email,password});
  }

logout(){
  sessionStorage.removeItem('emailId');
  sessionStorage.removeItem('token');
  this.router.navigateByUrl('/menu');
}
isloggedIn() {
  return !!sessionStorage.getItem('token');;
}
}