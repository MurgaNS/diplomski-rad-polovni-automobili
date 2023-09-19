import {Component} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
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
          this.router.navigate(['/Login']);
        },
        error: (error) => {
          console.log(error);
          alert("Error in registration")
        },
        complete: () => {
          this.router.navigate(['/Login'])
          alert("Please check your e-mail address")
        }
      })

  }

  ngOnInit(): void {
    this.registrationFormGroup = this.formBuilder.group({
      email: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      password: ['', [Validators.required]],
      firstName: ['', [Validators.required, Validators.minLength(3)]],
      lastName: ['', [Validators.required, Validators.minLength(3)]],
      username: ['', [Validators.required, Validators.minLength(3)]],
      country: ['', [Validators.required]],
      city: ['', [Validators.required]],
      district: ['', [Validators.required]],
      zip: ['', [Validators.required]],
      address: ['', [Validators.required, Validators.minLength(3)]],
      phoneNumber: ['', [Validators.required]],
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.registrationFormGroup.controls;
  }

}
