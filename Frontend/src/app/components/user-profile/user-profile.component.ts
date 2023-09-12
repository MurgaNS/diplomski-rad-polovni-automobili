import {Component, Input} from '@angular/core';
import {UserResponseDTO} from "../../models/dto/User/userResponseDTO.model";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent {

  constructor(private userService: UserService) {
  }

  user: UserResponseDTO = new UserResponseDTO();

  ngOnInit(): void {
    this.userService.GetProfileInfo()
      .subscribe({
        next: (data) => {
          this.user = data;
        }
      })
  }
}
