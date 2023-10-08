import { Component } from '@angular/core';
import {AuthenticationService} from "../../security/authentication/authentication.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private authService:AuthenticationService) {
  }

  logout() {
    return this.authService.logout();
  }

  hasLoggedIn() {
    return this.authService.hasLoggedIn();
  }

  isAdmin(){
    return this.authService.isAdmin();
  }

}
