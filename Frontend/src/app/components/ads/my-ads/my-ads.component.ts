import { Component } from '@angular/core';
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {AdService} from "../../../services/ad.service";

@Component({
  selector: 'app-my-ads',
  templateUrl: './my-ads.component.html',
  styleUrls: ['./my-ads.component.css']
})
export class MyAdsComponent {

  ads:AdResponseDTO[] = [];

  constructor(private adService: AdService) { }

  ngOnInit(): void {
    this.adService.GetUserAds()
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
