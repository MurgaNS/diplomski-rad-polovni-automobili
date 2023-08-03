import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdsComponent} from "./components/ads/ads/ads.component";
import {LoginComponent} from "./components/login/login.component";
import {AdViewComponent} from "./components/ads/ad-view/ad-view.component";
import {AdAddComponent} from "./components/ads/ad-add/ad-add.component";

const routes: Routes = [
  {
    path: "Main",
    component: AdsComponent
  },
  {
    path: "Login",
    component: LoginComponent
  },
  {
    path: "Ad-View/:id",
    component: AdViewComponent
  },
  {
    path: "Create-Ad",
    component: AdAddComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
