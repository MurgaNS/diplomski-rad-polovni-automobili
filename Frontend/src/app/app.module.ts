import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdsComponent } from './components/ads/ads/ads.component';
import { AdItemComponent } from './components/ads/ad-item/ad-item.component';
import { AdListComponent } from './components/ads/ad-list/ad-list.component';
import { AdViewComponent } from './components/ads/ad-view/ad-view.component';
import { AdAddComponent } from './components/ads/ad-add/ad-add.component';
import { HeaderComponent } from './components/header/header.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import {ReactiveFormsModule} from "@angular/forms";
import {TokenInterceptorService} from "./security/interceptor/token-interceptor.service";


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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
