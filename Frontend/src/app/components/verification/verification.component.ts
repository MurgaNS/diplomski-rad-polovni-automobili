import { Component } from '@angular/core';
import {AuthenticationService} from "../../security/authentication/authentication.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {UserResponseDTO} from "../../models/dto/User/userResponseDTO.model";
import {SignUpVerificationDTO} from "../../models/dto/User/signUpVerificationDTO.model";

@Component({
  selector: 'app-verification',
  templateUrl: './verification.component.html',
  styleUrls: ['./verification.component.css']
})
export class VerificationComponent {

  constructor(
    private authService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router,
  ) {
  }

  submitted = false;

  verificationFormGroup: FormGroup = new FormGroup({
    token: new FormControl(''),

  });

  onSubmit() {
    this.submitted = true;
    if (this.verificationFormGroup.invalid) {
      return;
    }

    let verification: SignUpVerificationDTO = new SignUpVerificationDTO();
    verification.token = this.verificationFormGroup.get("token")?.value;

    this.authService.VerifyAccount(verification)
      .subscribe({
        next: (data) => {
          this.router.navigate(['/Login']);
        },
        error: (error) => {
          console.log(error);
          alert("Error in account verification!")
        },
        complete: () => {
          this.router.navigate(['/Login'])
          alert("Token is correct!")
        }
      })

  }

}
