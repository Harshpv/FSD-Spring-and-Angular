import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './common-components/header/header.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductComponent } from './pages/product/product.component';
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
import { RegistrationComponent } from './pages/registration/registration.component';

const routes: Routes = [
  {path:"",component:HeaderComponent},
  {path:"menu",component:SearchheaderComponent},
  {path:"cart",component:CartComponent},
  {path:"product",component:ProductComponent},
  {path:"registration",component:RegistrationComponent}
];

@NgModule({
 imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
