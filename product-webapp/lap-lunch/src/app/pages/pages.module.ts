import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//import { MenuComponentComponent } from './menu-component/menu-component.component';
import { CartComponent } from './cart/cart.component';
import { ProductComponent } from './product/product.component';
import { SearchheaderComponent } from './searchheader/searchheader.component';
import { CommonComponentsModule } from '../common-components/common-components.module';
import { AppRoutingModule } from '../app-routing.module';
import { filter } from 'rxjs';
import { FilterPipe } from './shared/filter.pipe';

//import { CommonComponentsModule } from '../common-components/common-components.module';

@NgModule({
  declarations: [
 
    CartComponent,
    ProductComponent,
    SearchheaderComponent,
    FilterPipe
  ],
  imports: [
    CommonModule,
    CommonComponentsModule,
    AppRoutingModule
    
  ],
  exports:[
    SearchheaderComponent,
    CartComponent,
    ProductComponent
  ]

})
export class PagesModule { }