import {Component} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {AuthenticationService} from "../../security/authentication/authentication.service";
import {Router} from "@angular/router";
import {UserResponseDTO} from "../../models/dto/User/userResponseDTO.model";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  constructor(
    private authService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router,
  ) {
  }

  submitted = false;

  registrationFormGroup: FormGroup = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    username: new FormControl(''),
    country: new FormControl(''),
    city: new FormControl(''),
    district: new FormControl(''),
    zip: new FormControl(''),
    address: new FormControl(''),
    phoneNumber: new FormControl(''),
    role: new FormControl(''),

  });

  onSubmit() {
    this.submitted = true;
    if (this.registrationFormGroup.invalid) {
      return;
    }

    let register: UserResponseDTO = new UserResponseDTO();
    register.firstName = this.registrationFormGroup.get("firstName")?.value;
    register.lastName = this.registrationFormGroup.get("lastName")?.value;
    register.email = this.registrationFormGroup.get("email")?.value;
    register.password = this.registrationFormGroup.get("password")?.value;
    register.username = this.registrationFormGroup.get("username")?.value;
    register.country = this.registrationFormGroup.get("country")?.value;
    register.city = this.registrationFormGroup.get("city")?.value;
    register.district = this.registrationFormGroup.get("district")?.value;
    register.zip = this.registrationFormGroup.get("zip")?.value;
    register.address = this.registrationFormGroup.get("address")?.value;
    register.phoneNumber = this.registrationFormGroup.get("phoneNumber")?.value;
    register.role = "REGULAR";


    this.authService.Register(register)
      .subscribe({
        next: (data) => {
          this.router.navigate(['/Verify-Account']);
        },
        error: (error) => {
          console.log(error);
          alert("Error in registration")
        },
        complete: () => {
          this.router.navigate(['/Verify-Account'])
          alert("Please check your e-mail address")
        }
      })

  }

}
