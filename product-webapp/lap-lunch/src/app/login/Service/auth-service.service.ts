import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import { Login } from '../login';
// import{router} from '.angular/router';
@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  token:any;
  decodedToken:any;
  helper= new JwtHelperService();

  constructor(private http:HttpClient,private jwtHelper :JwtHelperService, private router:Router) { }
  
  login(email:string, password:string )  {
    return this.http.post<Login>('http://localhost:8080/api/v1/auth/login', {email, password})
  }

logout(){
  sessionStorage.removeItem('emailId');
  sessionStorage.removeItem('token');
  this.router.navigateByUrl('');
}
// isloggedIn() {
//   const token = sessionStorage.getItem('token');
//   return !this.helper.isTokenExpired(this.token);
// }
isloggedIn() {
  return !!sessionStorage.getItem('token');;
}
}