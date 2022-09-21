import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ɵNgNoValidate } from '@angular/forms';
import { MatSnackBar} from '@angular/material/snack-bar';
import { MatTooltipModule } from '@angular/material/tooltip';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
// import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthServiceService } from './Service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {

  decodedToken:any;
  message:any;
  action:any;
  helper= new JwtHelperService();

  constructor( private fb:FormBuilder, private authService:AuthServiceService,private mattooltip:MatTooltipModule, private router: Router,private snackbar:MatSnackBar) {}


loginform =this.fb.group({
  email: [null,[Validators.email,Validators.required]],
  password:[null,[Validators.required,Validators.minLength(8)]],
})
ngonit(){

}
// openSnackBar(message: string, action: string) {
//   this.snackbar.open(message, action);
// }
  
login() {
    const val = this.loginform.value;
    
    if (val.email && val.password) {
        this.authService.login(val.email, val.password)
            .subscribe(
                (result) => {
                    console.log(result);
                    this.decodedToken= this.helper.decodeToken(result.token);
                    sessionStorage.setItem("emailId",this.decodedToken.sub);
                    sessionStorage.setItem('token',result.token);
                    this.loginform.reset();
                    this.router.navigateByUrl('/').then(()=>{
                      this.snackbar.open("You are logged in!","OK",{
                        duration:2500,
                      });
                    });
                }
            )
    }
    else{
      this.snackbar.open("please enter correct details","OK");
      console.log("enter correct details")
      alert("enter correct details");
      this.loginform.reset();
    }
}
}