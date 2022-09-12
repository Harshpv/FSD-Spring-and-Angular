import { RecommendationComponent } from './pages/recommendation/recommendation.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './common-components/header/header.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductComponent } from './pages/product/product.component';
<<<<<<< HEAD
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
// <<<<<<< HEAD
import { RegistrationComponent } from './pages/registration/registration.component';
// =======
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component'; //i have mentioed thid line
// >>>>>>> 2c483c9a7c9844d09ddacfed2034688de3dad146

const routes: Routes = [
  {path:'',component:HeaderComponent},
  {path:"menu",component:SearchheaderComponent},
  {path:"cart",component:CartComponent},
  {path:"product",component:ProductComponent},
// <<<<<<< HEAD
  {path:"login", component:LoginComponent},
  // 
// =======
// <<<<<<< HEAD
  {path:"registration",component:RegistrationComponent},
// =======
  {path:"subscriptionplan",component:SubscriptionPlansComponent}  // i have mentioned this lie
// >>>>>>> 2c483c9a7c9844d09ddacfed2034688de3dad146
// >>>>>>> 65d5bb22656b3c9768134d7de5eca1f310d778eb
=======
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
  { path: 'recommendation', component: RecommendationComponent },

>>>>>>> 9e5fba09bf45273597e363e8cabb9b6c908c93c3
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
