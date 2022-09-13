import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

import { Address } from './address.model';
import { User } from './user.model';
import { UserService } from './user.service';
import { Router } from '@angular/router';
import { CustomvalidationService } from './customvalidation.service';
import { AuthServiceService } from 'src/app/login/Service/auth-service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  regForm! : FormGroup;
  addrss : Address = new Address();

  constructor(private service : UserService, private router: Router,
    private authService:AuthServiceService, private builder: FormBuilder, private customValidator : CustomvalidationService) { }
  message:any;
  ngOnInit(): void {
    this.regForm = this.builder.group({
      userEmailId : ['', [Validators.required, Validators.email]],
      firstName : ['', Validators.required],
      lastName : ['', Validators.required],
      password : ['', Validators.compose([Validators.required, this.customValidator.patternValidator()])],
      confirmPassword: ['', [Validators.required]],
      address : [[this.addrss]]
    },

    {
      validator: this.customValidator.MatchPassword('password', 'confirmPassword'),
    }
    );
  }
  submitted:boolean = false;
  get f() { return this.regForm.controls; }
 
  
 
 
  onSubmit(){
    this.submitted = true;
    if (this.regForm.valid) {
      console.table(this.regForm.value);
      this.registerNow();
    } 
  }
  

  public registerNow(){
    this.service.addUser(this.regForm.value).subscribe(
      (data) =>{ this.message=data
      this.authService.addUser(this.regForm.controls['userEmailId'].value,this.regForm.controls['password'].value)
      .subscribe()
      }
      )
  
    console.log(this.message);
    this.router.navigateByUrl('/login')
      
  }

}
