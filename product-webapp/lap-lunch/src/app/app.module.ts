import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
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

//profile components
import { MatCommonModule } from '@angular/material/core';
// import { ServiceComponent } from './service/service.component';
import { MatCardModule } from '@angular/material/card';
import { JwtHelperService, JWT_OPTIONS } from '@auth0/angular-jwt';
import { provideRoutes } from '@angular/router';
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component';
import { SubscribedPlanComponent } from './subscribed-plan/subscribed-plan.component';
import { MatInputModule } from '@angular/material/input';
import { CommonModule } from '@angular/common';
//import { ProfilepageModule } from 'src/profilepage/profilepage.module';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SubscriptionPlansComponent,
    SubscribedPlanComponent,
    
    SubscriptionPlansComponent,
    SubscribedPlanComponent,

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
    MatInputModule,
    CommonModule,
    
    // AuthServiceService
  ],
  providers: [
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
