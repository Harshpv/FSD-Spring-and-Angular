import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { ProfilepageComponent } from './profilepage.component';
import { OrdersComponent } from './orders/orders.component';
import { AddressesComponent } from './addresses/addresses.component';
import { SubscriptionComponent } from './subscription/subscription.component';

const routes: Routes = [
  {
    path: 'profilepage',
    component: ProfilepageComponent,
    children: [
      { path: 'orders', component: OrdersComponent },
      {
        path: 'addresses',
        component: AddressesComponent,
      },
      {
        path: 'subscription',
        component: SubscriptionComponent,
      },
    ],
  },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfilepageRoutingModule {}
