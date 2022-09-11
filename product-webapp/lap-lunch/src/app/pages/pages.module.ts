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
<<<<<<< HEAD
import { RegistrationComponent } from './registration/registration.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
=======
import { RecommendationComponent } from './recommendation/recommendation.component';
>>>>>>> 2c483c9a7c9844d09ddacfed2034688de3dad146

//import { CommonComponentsModule } from '../common-components/common-components.module';

@NgModule({
  declarations: [
 
    CartComponent,
    ProductComponent,
    SearchheaderComponent,
    FilterPipe,
<<<<<<< HEAD
    RegistrationComponent,
    
=======
    RecommendationComponent
>>>>>>> 2c483c9a7c9844d09ddacfed2034688de3dad146
  ],
  imports: [
    CommonModule,
    CommonComponentsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
    
  ],
  exports:[
    SearchheaderComponent,
    CartComponent,
    ProductComponent
  ]

})
export class PagesModule { }
