import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AdsComponent} from './components/ads/ads/ads.component';
import {AdItemComponent} from './components/ads/ad-item/ad-item.component';
import {AdListComponent} from './components/ads/ad-list/ad-list.component';
import {AdViewComponent} from './components/ads/ad-view/ad-view.component';
import {AdAddComponent} from './components/ads/ad-add/ad-add.component';
import {HeaderComponent} from './components/header/header.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {LoginComponent} from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {TokenInterceptorService} from "./security/interceptor/token-interceptor.service";
import {MyAdsComponent} from './components/ads/my-ads/my-ads.component';
import {FollowingAdsComponent} from './components/ads/following-ads/following-ads.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSelectModule} from '@angular/material/select';
import {ReportedAdsComponent} from './components/adminPanel/reported-ads/reported-ads.component';
import {ReportedAdListComponent} from './components/adminPanel/reported-ad-list/reported-ad-list.component';
import {ReportedAdItemComponent} from './components/adminPanel/reported-ad-item/reported-ad-item.component';
import {InactiveAdsComponent} from './components/adminPanel/inactive-ads/inactive-ads.component';
import {AddEditComponent} from './components/ads/add-edit/add-edit.component';
import {RegistrationComponent} from './components/registration/registration.component';
import {VerificationComponent} from './components/verification/verification.component';
import {ChangePasswordComponent} from './components/change-password/change-password.component';
import {NgImageSliderModule} from "ng-image-slider";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import {MatCheckboxModule} from "@angular/material/checkbox";


@NgModule({
  declarations: [
    AppComponent,
    AdsComponent,
    AdItemComponent,
    AdListComponent,
    AdViewComponent,
    AdAddComponent,
    HeaderComponent,
    LoginComponent,
    MyAdsComponent,
    FollowingAdsComponent,
    ReportedAdsComponent,
    ReportedAdListComponent,
    ReportedAdItemComponent,
    InactiveAdsComponent,
    AddEditComponent,
    RegistrationComponent,
    VerificationComponent,
    ChangePasswordComponent,
    UserProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSelectModule,
    FormsModule,
    NgImageSliderModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatCheckboxModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
