import { Component } from '@angular/core';
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {AdService} from "../../../services/ad.service";
import {ReportService} from "../../../services/report.service";
import {ReportResponseDTO} from "../../../models/dto/Report/reportResponseDTO.model";

@Component({
  selector: 'app-reported-ads',
  templateUrl: './reported-ads.component.html',
  styleUrls: ['./reported-ads.component.css']
})
export class ReportedAdsComponent {

  reportedAds:ReportResponseDTO[] = [];

  constructor(private reportService: ReportService) { }

  ngOnInit(): void {
    this.reportService.GetAllReports()
      .subscribe({
        next: (data) => {
          this.reportedAds = data;
        },
        error: (error) => {
          console.log(error)
        }
      })
  }

}
