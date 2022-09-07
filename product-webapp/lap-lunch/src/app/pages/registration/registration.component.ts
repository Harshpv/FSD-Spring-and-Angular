import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  registrationForm = new FormGroup({
    userEmailId : new FormControl(''),
    firstName : new FormControl(),
    lastName : new FormControl,
    password : new FormControl
  })

}
