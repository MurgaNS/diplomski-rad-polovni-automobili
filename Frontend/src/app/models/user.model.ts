import {Ad} from "./ad.model";

export class User {

  id: number = 0;
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
  verification:boolean = false;
  role: string = "";
  ads: Ad[] = [];
  followedAds: Ad[] = [];

  User(id: number, firstName: string, lastName: string, username: string, password: string, country: string, city: string, district: string, zip: number, address: string, phoneNumber: string, email: string, verification: boolean, role: string, ads: Ad[], followedAds: Ad[]) {
    this.id = id;
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
    this.verification = verification;
    this.role = role;
    this.ads = ads;
    this.followedAds = followedAds;
  }
}
