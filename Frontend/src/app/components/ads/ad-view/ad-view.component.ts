import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdService} from "../../../services/ad.service";
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";

@Component({
  selector: 'app-ad-view',
  templateUrl: './ad-view.component.html',
  styleUrls: ['./ad-view.component.css']
})
export class AdViewComponent {

  constructor(private route:ActivatedRoute,
              private adService:AdService) {}

  ad_id = Number(this.route.snapshot.paramMap.get("id"))
  ad:AdResponseDTO = new AdResponseDTO();

  ngOnInit(): void {
    console.log(this.ad_id)
    this.adService.GetById(this.ad_id)
      .subscribe({
        next:(data) => {
          this.ad=data
        }

      })
  }


}
