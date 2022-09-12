import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartComponent } from './cart/cart.component';
import { ProductComponent } from './product/product.component';
import { SearchheaderComponent } from './searchheader/searchheader.component';
import { CommonComponentsModule } from '../common-components/common-components.module';
import { AppRoutingModule } from '../app-routing.module';
import { filter } from 'rxjs';
import { FilterPipe } from './shared/filter.pipe';
import { RegistrationComponent } from './registration/registration.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { RecommendationComponent } from './recommendation/recommendation.component';
<<<<<<< HEAD

=======
>>>>>>> 9e5fba09bf45273597e363e8cabb9b6c908c93c3

@NgModule({
  declarations: [
    CartComponent,
    ProductComponent,
    SearchheaderComponent,
    FilterPipe,
    RegistrationComponent,
<<<<<<< HEAD
    
    RecommendationComponent
=======

    RecommendationComponent,
>>>>>>> 9e5fba09bf45273597e363e8cabb9b6c908c93c3
  ],
  imports: [
    CommonModule,
    CommonComponentsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [SearchheaderComponent, CartComponent, ProductComponent],
})
export class PagesModule {}
