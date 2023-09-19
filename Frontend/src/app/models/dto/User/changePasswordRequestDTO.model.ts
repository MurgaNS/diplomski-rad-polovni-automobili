export class ChangePasswordRequestDTO {

  currentPassword: string = "";
  newPassword: string = "";
  confirmNewPassword: string = "";


  ChangePasswordRequestDTO(currentPassword: string, newPassword: string, confirmNewPassword: string) {

    this.currentPassword = currentPassword;
    this.newPassword = newPassword;
    this.confirmNewPassword = confirmNewPassword;
  }
}
