import {Component} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../security/authentication/authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(
    private authService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router,
  ) {}

  formGroup: FormGroup = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      email: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      password: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  submitted = false;
  forbidden = false;

  onSubmit() {

    this.submitted = true;
    if (this.formGroup.invalid) {
      return;
    }

    this.authService.Login(this.formGroup.value.email, this.formGroup.value.password).subscribe((data) => {
      this.router.navigate(["/Main"])

    }, (error) => {
      this.forbidden = true;
    })
  }

}
