export class SignUpVerificationDTO {

  token: string = "";

  SignupVerificationDTO(token: string) {
    this.token = token;
  }
}
