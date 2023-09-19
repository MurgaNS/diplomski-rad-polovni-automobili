export class UserResponseDTO {

  firstName: string = "";
  lastName:string = "";
  username:string = "";
  password:string = "";
  country:string = "";
  city:string = "";
  district:string = "";
  zip:number = 0;
  address:string = "";
  phoneNumber:string = "";
  email:string = "";
  role: string = "";


  UserResponseDTO(firstName: string, lastName: string, username: string, password: string, country: string, city: string, district: string, zip: number, address: string, phoneNumber: string, email: string, role: string) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.country = country;
    this.city = city;
    this.district = district;
    this.zip = zip;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.role = role;
  }
}
