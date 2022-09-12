import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ɵNgNoValidate } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthServiceService } from './Service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  form :FormGroup;
  decodedToken:any;
  helper= new JwtHelperService();
  constructor( private fb:FormBuilder, private authService:AuthServiceService, private router: Router) {
  
    this.form =this.fb.group({
    // email: new FormControl('', Validators.required),
    // password: new FormControl('', Validators.required),
    email: new FormControl('', Validators.compose([
                Validators.required,
                Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-z]+.[a-z]+$'),
              ])),
    password: new FormControl('', Validators.compose([
                Validators.required,
                Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')]))

  })
}
ngonit(){
  
}
  
login() {
    const val = this.form.value;

    if (val.email && val.password) {
        this.authService.login(val.email, val.password)
            .subscribe(
                (result) => {
                    console.log(result);
                    this.decodedToken= this.helper.decodeToken(result.token);
                    sessionStorage.setItem("emailId",this.decodedToken.sub);
                    sessionStorage.setItem('token',result.token);
                    this.form.reset();
                    this.router.navigateByUrl('/menu');
                }
            )
    }else{
      console.log("enter correct details");
      alert("enter correct details");
      this.form.reset();
    }
}
}