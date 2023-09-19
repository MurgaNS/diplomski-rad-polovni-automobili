import { Component } from '@angular/core';
import {AuthenticationService} from "../../security/authentication/authentication.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
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
    private router: Router,
    private route: ActivatedRoute
  ) {
  }


  ngOnInit():void {

    this.route.params.subscribe(params => {
      const token = params['token'];
      console.log(token)
      let signUpDTO:SignUpVerificationDTO = new SignUpVerificationDTO();
      signUpDTO.token = token
      this.authService.VerifyAccount(signUpDTO)
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
            alert("Registration is successful")
          }
        })
    })

  }

}
