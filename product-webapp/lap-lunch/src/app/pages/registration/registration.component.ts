import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { Address } from './address.model';
import { User } from './user.model';
import { UserService } from './user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  address : Address = new Address(0,'','','','',0)
  user : User = new User('','','','',[this.address])
  

  constructor(private service : UserService) { }
  message:any;
  ngOnInit(): void {
  }
  // registrationForm = new FormGroup({
  //   userEmailId : new FormControl(''),
  //   firstName : new FormControl(),
  //   lastName : new FormControl,
  //   password : new FormControl
  // })
  // addressModel = new address(12, "1-2/3", "2nd line", "Guntur", "Andhra Pradesh", 273818)
  // userModel = new User("abhishek@gmail.com", "Abhishek", "Pasumarthi", "password", [this.addressModel ])
  
  
  public registerNow(){
    this.service.addUser(this.user).subscribe((data) => this.message=data)
    console.log(this.message);
    
  }

}
