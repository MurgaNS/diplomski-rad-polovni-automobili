import { Component } from '@angular/core';
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {AdService} from "../../../services/ad.service";

@Component({
  selector: 'app-inactive-ads',
  templateUrl: './inactive-ads.component.html',
  styleUrls: ['./inactive-ads.component.css']
})
export class InactiveAdsComponent {

  ads:AdResponseDTO[] = [];

  constructor(private adService: AdService) { }

  ngOnInit(): void {
    this.adService.GetAllInactive()
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
