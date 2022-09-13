import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ɵNgNoValidate } from '@angular/forms';
import { Router } from '@angular/router';
// import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthServiceService } from './Service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {

  decodedToken:any;
  // submitted:any;
  // touched:any;
  // invalid:any;

  // helper= new JwtHelperService();

  constructor( private fb:FormBuilder, private authService:AuthServiceService, private router: Router) {}

loginform =this.fb.group({
  email: [null,[Validators.email,Validators.required]],
  password:[null,[Validators.required,Validators.minLength(8)]],
})
ngonit(){

}
  
login() {
    const val = this.loginform.value;
    
    if (val.email && val.password) {
        this.authService.login(val.email, val.password)
            .subscribe(
                (result) => {
                    console.log(result);
                    // this.decodedToken= this.helper.decodeToken(result.token);
                    sessionStorage.setItem("emailId",this.decodedToken.sub);
                    sessionStorage.setItem('token',result.token);
                    this.loginform.reset();
                    this.router.navigateByUrl('/menu');
                }
            )
    }
    else{
      console.log("enter correct details");
      alert("enter correct details");
      this.loginform.reset();
    }
}
addUser(){
  // this.authService.addUser(this.loginform.value).subscribe((data) => this.message=data)
  // console.log(this.message);
  this.router.navigateByUrl('/menu')
  
}
}