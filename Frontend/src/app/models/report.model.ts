import {Ad} from "./ad.model";

export class Report {

  id: number = 0;
  reportReason:string = "";
  isAccepted: boolean = false;
  ad: Ad = new Ad;

  Report(id: number, reportReason: string, isAccepted: boolean, ad: Ad) {
    this.id = id;
    this.reportReason = reportReason;
    this.isAccepted = isAccepted;
    this.ad = ad;
  }
}
