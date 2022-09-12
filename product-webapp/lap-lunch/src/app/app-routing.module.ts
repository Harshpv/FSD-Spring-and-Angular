import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './common-components/header/header.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductComponent } from './pages/product/product.component';
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
import { TimetableComponent } from './pages/timetable/timetable.component';
const routes: Routes = [
  {path:' ',redirectTo:'menu',pathMatch:'full'},
  {path:"menu",component:SearchheaderComponent},
  {path:"cart",component:CartComponent},
  {path:"search/:searchItem",component: SearchheaderComponent},
  {path:"timetable", component:TimetableComponent}
];

@NgModule({
 imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  params: any;
}
