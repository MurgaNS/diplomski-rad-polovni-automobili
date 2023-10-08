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
import {CanActivateAuthGuard} from "./security/authentication/can-activate-auth.guard";

const routes: Routes = [
  {path: "Main", component: AdsComponent},
  {path: "Login", component: LoginComponent},
  {path: "Registration", component: RegistrationComponent},
  {path: "Verify-Account/:token", component: VerificationComponent},
  {path: "Change-Password", component: ChangePasswordComponent},
  {path: "My-Profile", component: UserProfileComponent, canActivate: [CanActivateAuthGuard], title: 'Used Cars | My Profile'},
  {path: "Ad-View/:id", component: AdViewComponent},
  {path: "Create-Ad", component: AdAddComponent, canActivate: [CanActivateAuthGuard], title: 'Used Cars | Create Ad'},
  {path: "My-Ads", component: MyAdsComponent, canActivate: [CanActivateAuthGuard], title: 'Used Cars | My Ads'},
  {path: "Following-Ads", component: FollowingAdsComponent, canActivate: [CanActivateAuthGuard], title: 'Used Cars | Following ads'},
  {path: "Reported-Ads", component: ReportedAdsComponent, canActivate: [CanActivateAuthGuard], title: 'Used Cars | Reported Ads'},
  {path: "Inactive-Ads", component: InactiveAdsComponent, canActivate: [CanActivateAuthGuard], title: 'Used Cars | Inactive ads'},
  {path: "Ad-Edit/:id", component: AddEditComponent, canActivate: [CanActivateAuthGuard], title: 'Used Cars | Edit Ad'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
