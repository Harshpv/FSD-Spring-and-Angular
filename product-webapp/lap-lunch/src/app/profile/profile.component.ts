import { Component, OnInit } from '@angular/core';
import { OrderModel } from './profile.model';
import { ProfileServiceService } from './profile-service.service';
import { userModel } from './address/address.model';
import { AddressServiceService } from './address/address-service.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  userEmailId: string = 'example@gmail.com';
  orderData!: OrderModel[];
  userData!: userModel;
  userformValue: any;

  constructor(
    private api: ProfileServiceService,
    private ordersApi: AddressServiceService,
    private formbuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.userformValue = this.formbuilder.group({
      firstName: [],
      lastName: [],
      mobileNum: [],
    });
    this.getAllOrdersByEmailId();
    this.getAllByUserEmailId();
  }

  getAllOrdersByEmailId() {
    this.api.getOrdersByemailId(this.userEmailId).subscribe((res) => {
      this.orderData = res;
      console.log(res);
    });
  }
  editButtonProfile() {
    this.userformValue.controls['firstName'].setValue(this.userData.firstName);
    this.userformValue.controls['lastName'].setValue(this.userData.lastName);
    this.userformValue.controls['mobileNum'].setValue(this.userData.mobileNum);
  }
  updateUserDetails() {
    this.userData.mobileNum = this.userformValue.value.mobileNum;
    this.userData.firstName = this.userformValue.value.firstName;
    this.userData.lastName = this.userformValue.value.lastName;
    this.ordersApi
      .updateAddressById(this.userEmailId, this.userData)
      .subscribe((res) => {
        console.log('updated');
        this.getAllByUserEmailId();
      });
    this.userformValue.reset();
  }
  getAllByUserEmailId() {
    this.ordersApi.getAddressesById(this.userEmailId).subscribe((res) => {
      this.userData = res;
    });
  }
}
