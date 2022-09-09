import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonComponentsModule } from './common-components/common-components.module';
import { PagesModule } from './pages/pages.module';
import {MatToolbarModule} from '@angular/material/toolbar';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Allitems } from './pages/Items/allitems';
//import { FilterPipe } from './pages/shared/filter.pipe';
//import { MenuComponentComponent } from './menu-component/menu-component.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component';
import { SubscribedPlanComponent } from './subscribed-plan/subscribed-plan.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SubscriptionPlansComponent,
    SubscribedPlanComponent,
  //  FilterPipe,
   
    
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
    FormsModule

  

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
