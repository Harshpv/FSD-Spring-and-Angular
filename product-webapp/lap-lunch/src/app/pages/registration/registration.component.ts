import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

import { Address } from './address.model';
import { User } from './user.model';
import { UserService } from './user.service';
import { Router } from '@angular/router';
import { CustomvalidationService } from './customvalidation.service';
import { AuthServiceService } from 'src/app/login/Service/auth-service.service';
import { MatTooltipModule } from '@angular/material/tooltip';
import { RecommendationService } from './../../recommendation.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  regForm! : FormGroup;

   user: User =  {
    userEmailId: '',
    firstName : '',
    lastName : '',
    password : '',
    address : []

  };


  constructor(private service : UserService, private router: Router,
    private authService:AuthServiceService, private builder: FormBuilder,
    private matTooltip:MatTooltipModule, private customValidator : CustomvalidationService,
    private recommendation:RecommendationService) { }
  message:any;
  ngOnInit(): void {
    this.regForm = this.builder.group({
      userEmailId : ['', [Validators.required, Validators.email]],
      firstName : ['', Validators.required],
      lastName : ['', Validators.required],
      password : ['', Validators.compose([Validators.required, this.customValidator.patternValidator()])],
      confirmPassword: ['', [Validators.required]],
      address : [[]]
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
    this.user.userEmailId = this.regForm.value.userEmailId;
    this.user.firstName = this.regForm.value.firstName;
    this.user.lastName = this.regForm.value.lastName;
    this.user.password = this.regForm.value.password;
    this.user.address = this.regForm.value.address;
    this.service.addUser(this.user).subscribe((data) => {this.message=data
      this.authService.addUser(this.regForm.controls['userEmailId'].value,this.regForm.controls['password'].value)
      .subscribe();
      this.recommendation.addUser(this.user).subscribe();
    },
    )
    console.log(this.message);
    this.router.navigateByUrl('/login')
      
  }

}
