import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './common-components/header/header.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductComponent } from './pages/product/product.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
import { AddressComponent } from './profile/address/address.component';

import { ProfileComponent } from './profile/profile.component';

import { SubscriptionComponent } from './profile/subscription/subscription.component';
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component';

const routes: Routes = [
  { path: '', component: HeaderComponent },
  { path: 'menu', component: SearchheaderComponent },
  { path: 'cart', component: CartComponent },
  { path: 'product', component: ProductComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'profile-address', component: AddressComponent },
  { path: 'profile-subscription', component: SubscriptionComponent },

  { path: 'login', component: LoginComponent },

  { path: 'registration', component: RegistrationComponent },

  { path: 'subscriptionplan', component: SubscriptionPlansComponent }, // i have mentioned this lie
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
