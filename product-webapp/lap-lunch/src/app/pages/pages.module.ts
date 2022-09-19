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
import { LoginComponent } from '../login/login.component';
import { TimetableComponent } from './timetable/timetable.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    CartComponent,
    ProductComponent,
    SearchheaderComponent,
    FilterPipe,
    RegistrationComponent, 
    RecommendationComponent,
    RecommendationComponent,
    RegistrationComponent,

    RecommendationComponent,
    TimetableComponent
  ],
  imports: [
    CommonModule,
    CommonComponentsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [SearchheaderComponent, CartComponent, ProductComponent],
})
export class PagesModule {}
