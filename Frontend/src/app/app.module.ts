import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdsComponent } from './components/ads/ads/ads.component';
import { AdItemComponent } from './components/ads/ad-item/ad-item.component';
import { AdListComponent } from './components/ads/ad-list/ad-list.component';
import { AdViewComponent } from './components/ads/ad-view/ad-view.component';
import { AdAddComponent } from './components/ads/ad-add/ad-add.component';
@NgModule({
  declarations: [
    AppComponent,
    AdsComponent,
    AdItemComponent,
    AdListComponent,
    AdViewComponent,
    AdAddComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
