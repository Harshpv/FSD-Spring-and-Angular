import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './common-components/header/header.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductComponent } from './pages/product/product.component';
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
import { AddressComponent } from './profile/address/address.component';
import { OrdersComponent } from './profile/orders/orders.component';
import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './profile/settings/settings.component';
import { SubscriptionComponent } from './profile/subscription/subscription.component';

const routes: Routes = [
  { path: '', component: HeaderComponent },
  { path: 'menu', component: SearchheaderComponent },
  { path: 'cart', component: CartComponent },
  { path: 'product', component: ProductComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'profile-address', component: AddressComponent },
  { path: 'profile-subscription', component: SubscriptionComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
