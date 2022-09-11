import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './common-components/header/header.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductComponent } from './pages/product/product.component';
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
import { AddressComponent } from './profile/address/address.component';
import { OrdersComponent } from './profile/orders/orders.component';
import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './profile/settings/settings.component';
import { SubscriptionComponent } from './profile/subscription/subscription.component';

const routes: Routes = [
<<<<<<< HEAD
  { path: '', component: HeaderComponent },
  { path: 'menu', component: SearchheaderComponent },
  { path: 'cart', component: CartComponent },
  { path: 'product', component: ProductComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'profile-address', component: AddressComponent },
  { path: 'profile-subscription', component: SubscriptionComponent },
=======
  {path:' ',redirectTo:'menu',pathMatch:'full'},
  {path:"menu",component:SearchheaderComponent},
  {path:"cart",component:CartComponent},
  {path:"product",component:ProductComponent},
<<<<<<< HEAD
  {path:"login", component:LoginComponent},
  
=======
<<<<<<< HEAD
  {path:"registration",component:RegistrationComponent}
=======
  {path:"subscriptionplan",component:SubscriptionPlansComponent}  // i have mentioned this lie
>>>>>>> 2c483c9a7c9844d09ddacfed2034688de3dad146
>>>>>>> 65d5bb22656b3c9768134d7de5eca1f310d778eb
>>>>>>> 9c62fb28a782f595e0938e9f6326e871b231d827
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
