import { Component } from '@angular/core';
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {AdService} from "../../../services/ad.service";

@Component({
  selector: 'app-following-ads',
  templateUrl: './following-ads.component.html',
  styleUrls: ['./following-ads.component.css']
})
export class FollowingAdsComponent {

  ads:AdResponseDTO[] = [];

  constructor(private adService: AdService) { }

  ngOnInit(): void {
    this.adService.GetUserFollowedAds()
      .subscribe({
        next: (data) => {
          this.ads = data;
        },
        error: (error) => {
          console.log(error)
        }
      })
  }

}
