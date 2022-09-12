import { Component, OnInit } from '@angular/core';
import { OrderModel } from './profile.model';
import { ProfileServiceService } from './profile-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  orderData!: OrderModel[];

  constructor(private api: ProfileServiceService) {}

  ngOnInit(): void {
    this.getAllOrders();
  }

  getAllOrders() {
    this.api.getOrders().subscribe((res) => {
      this.orderData = res;
      console.log(res);
    });
  }
}
