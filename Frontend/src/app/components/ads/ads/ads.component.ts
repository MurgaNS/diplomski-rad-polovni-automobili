import { Component } from '@angular/core';
import {AdService} from "../../../services/ad.service";
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";

@Component({
  selector: 'app-ads',
  templateUrl: './ads.component.html',
  styleUrls: ['./ads.component.css']
})
export class AdsComponent {

  ads:AdResponseDTO[] = [];

  constructor(private adService: AdService) { }

  ngOnInit(): void {
    this.adService.GetAllActive()
      .subscribe({
        next: (data) => {
          this.ads = data;
        },
        error: (error) => {
          console.log(error)
        }
      })
  }

  searchAds(ads: AdResponseDTO[]) {
    this.ads = ads;
  }

}
