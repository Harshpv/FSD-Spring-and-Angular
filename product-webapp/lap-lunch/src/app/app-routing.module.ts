import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './common-components/header/header.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductComponent } from './pages/product/product.component';
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
<<<<<<< HEAD
import { RegistrationComponent } from './pages/registration/registration.component';
=======
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component'; //i have mentioed thid line
>>>>>>> 2c483c9a7c9844d09ddacfed2034688de3dad146

const routes: Routes = [
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
];

@NgModule({
 imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
