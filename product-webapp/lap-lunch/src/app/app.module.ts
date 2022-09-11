import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// import { IonInput } from '@ionic/angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonComponentsModule } from './common-components/common-components.module';
import { PagesModule } from './pages/pages.module';
import {MatToolbarModule} from '@angular/material/toolbar';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
<<<<<<< HEAD
import { ProfileComponent } from './profile/profile.component';
import { OrdersComponent } from './profile/orders/orders.component';
import { SubscriptionComponent } from './profile/subscription/subscription.component';
import { AddressComponent } from './profile/address/address.component';
import { SettingsComponent } from './profile/settings/settings.component';
=======
<<<<<<< HEAD
import { MatFormField, matFormFieldAnimations } from '@angular/material/form-field';
import { AuthServiceService } from './login/Service/auth-service.service';
import { MatCommonModule } from '@angular/material/core';
// import { ServiceComponent } from './service/service.component';
import {MatCardModule} from '@angular/material/card';
import { JwtHelperService, JWT_OPTIONS } from '@auth0/angular-jwt';
import { provideRoutes } from '@angular/router';
=======
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component';
import { SubscribedPlanComponent } from './subscribed-plan/subscribed-plan.component';

>>>>>>> 65d5bb22656b3c9768134d7de5eca1f310d778eb
>>>>>>> 9c62fb28a782f595e0938e9f6326e871b231d827

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
<<<<<<< HEAD
    ProfileComponent,
    OrdersComponent,
    SubscriptionComponent,
    AddressComponent,
    SettingsComponent,
=======
<<<<<<< HEAD
=======
    SubscriptionPlansComponent,
    SubscribedPlanComponent,
>>>>>>> 9c62fb28a782f595e0938e9f6326e871b231d827
  //  FilterPipe,
   
>>>>>>> 65d5bb22656b3c9768134d7de5eca1f310d778eb
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CommonComponentsModule,
    PagesModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    HttpClientModule,
    MatCommonModule,
    MatCardModule,
    // AuthServiceService

  ],
  providers: [{ provide: JWT_OPTIONS, useValue: JWT_OPTIONS },JwtHelperService],
  bootstrap: [AppComponent]
})
export class AppModule { }
