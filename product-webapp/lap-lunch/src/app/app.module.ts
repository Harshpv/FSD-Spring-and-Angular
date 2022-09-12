import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// import { IonInput } from '@ionic/angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonComponentsModule } from './common-components/common-components.module';
import { PagesModule } from './pages/pages.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
<<<<<<< HEAD
import { MatFormField, matFormFieldAnimations } from '@angular/material/form-field';
=======

//profile components
import { ProfileComponent } from './profile/profile.component';
import { SubscriptionComponent } from './profile/subscription/subscription.component';
import { AddressComponent } from './profile/address/address.component';

import {
  MatFormField,
  matFormFieldAnimations,
} from '@angular/material/form-field';
>>>>>>> 9e5fba09bf45273597e363e8cabb9b6c908c93c3
import { AuthServiceService } from './login/Service/auth-service.service';
import { MatCommonModule } from '@angular/material/core';
// import { ServiceComponent } from './service/service.component';
import { MatCardModule } from '@angular/material/card';
import { JwtHelperService, JWT_OPTIONS } from '@auth0/angular-jwt';
import { provideRoutes } from '@angular/router';
<<<<<<< HEAD
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
=======

>>>>>>> 9e5fba09bf45273597e363e8cabb9b6c908c93c3
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component';
import { SubscribedPlanComponent } from './subscribed-plan/subscribed-plan.component';
import { MatInputModule } from '@angular/material/input';

<<<<<<< HEAD

=======
>>>>>>> 9e5fba09bf45273597e363e8cabb9b6c908c93c3
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
<<<<<<< HEAD
    SubscriptionPlansComponent,
    SubscribedPlanComponent,
  //  FilterPipe,
   
    
=======
    //profile components:
    ProfileComponent,
    SubscriptionComponent,
    AddressComponent,

    SubscriptionPlansComponent,
    SubscribedPlanComponent,

    //  FilterPipe,
>>>>>>> 9e5fba09bf45273597e363e8cabb9b6c908c93c3
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CommonComponentsModule,
    // SearchheaderComponent,
    PagesModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    HttpClientModule,
    MatCommonModule,
    MatCardModule,
    MatInputModule
    // AuthServiceService
  ],
  providers: [
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
