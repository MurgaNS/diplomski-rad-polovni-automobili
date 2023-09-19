import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdsComponent} from "./components/ads/ads/ads.component";
import {LoginComponent} from "./components/login/login.component";
import {AdViewComponent} from "./components/ads/ad-view/ad-view.component";
import {AdAddComponent} from "./components/ads/ad-add/ad-add.component";
import {MyAdsComponent} from "./components/ads/my-ads/my-ads.component";
import {FollowingAdsComponent} from "./components/ads/following-ads/following-ads.component";
import {ReportedAdsComponent} from "./components/adminPanel/reported-ads/reported-ads.component";
import {InactiveAdsComponent} from "./components/adminPanel/inactive-ads/inactive-ads.component";
import {AddEditComponent} from "./components/ads/add-edit/add-edit.component";
import {RegistrationComponent} from "./components/registration/registration.component";
import {VerificationComponent} from "./components/verification/verification.component";
import {ChangePasswordComponent} from "./components/change-password/change-password.component";
import {UserProfileComponent} from "./components/user-profile/user-profile.component";

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
    path: "Registration",
    component: RegistrationComponent
  },
  {
    path: "Verify-Account/:token",
    component: VerificationComponent
  },
  {
    path: "Change-Password",
    component: ChangePasswordComponent
  },
  {
    path: "My-Profile",
    component: UserProfileComponent
  },
  {
    path: "Ad-View/:id",
    component: AdViewComponent
  },
  {
    path: "Create-Ad",
    component: AdAddComponent,
  },
  {
    path: "My-Ads",
    component: MyAdsComponent,
  },
  {
    path: "Following-Ads",
    component: FollowingAdsComponent,
  },
  {
    path: "Reported-Ads",
    component: ReportedAdsComponent
  },
  {
    path: "Inactive-Ads",
    component: InactiveAdsComponent
  },
  {
    path: "Ad-Edit/:id",
    component: AddEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
