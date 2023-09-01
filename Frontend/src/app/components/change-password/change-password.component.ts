import { Component } from '@angular/core';
import {AuthenticationService} from "../../security/authentication/authentication.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {SignUpVerificationDTO} from "../../models/dto/User/signUpVerificationDTO.model";
import {ChangePasswordRequestDTO} from "../../models/dto/User/changePasswordRequestDTO.model";

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent {

  constructor(
    private authService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router,
  ) {
  }

  submitted = false;

  changePasswordFormGroup: FormGroup = new FormGroup({
    currentPassword: new FormControl(''),
    newPassword: new FormControl(''),
    confirmNewPassword: new FormControl(''),

  });

  onSubmit() {
    this.submitted = true;
    if (this.changePasswordFormGroup.invalid) {
      return;
    }

    let pwRequest: ChangePasswordRequestDTO = new ChangePasswordRequestDTO();
    pwRequest.currentPassword = this.changePasswordFormGroup.get("currentPassword")?.value;
    pwRequest.newPassword = this.changePasswordFormGroup.get("newPassword")?.value;
    pwRequest.confirmNewPassword = this.changePasswordFormGroup.get("confirmNewPassword")?.value;

    this.authService.ChangePassword(pwRequest)
      .subscribe({
        next: (data) => {
          this.router.navigate(['/Main']);
        },
        error: (error) => {
          console.log(error);
          alert("Error changing password!")
        },
        complete: () => {
          this.router.navigate(['/Main'])
          alert("Password successfully changed!")
        }
      })

  }

  showCurrent: boolean = false;
  showNew: boolean = false;
  showConfirm: boolean = false;

  currentPassword() {
    this.showCurrent = !this.showCurrent;
  }

  newPassword() {
    this.showNew = !this.showNew;
  }

  confirmNewPassword() {
    this.showConfirm = !this.showConfirm;
  }

}
