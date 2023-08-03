import {User} from "./user.model";
import {Report} from "./report.model";
import {Car} from "./car.model";

export class Ad {

  id: number = 0;
  status: string = "";
  price: number = 0;
  description: string = "";
  rejectedReason: string = "";
  car: Car = new Car();
  reports:Report[]=[];
  user: User = new User();
  users : User[] = [];


  Ad(id: number, status: string, price: number, description: string, rejectedReason: string, car: Car, reports: Report[], user: User, users: User[]) {
    this.id = id;
    this.status = status;
    this.price = price;
    this.description = description;
    this.rejectedReason = rejectedReason;
    this.car = car;
    this.reports = reports;
    this.user = user;
    this.users = users;
  }
}
