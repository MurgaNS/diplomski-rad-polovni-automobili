import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AdService} from "../../../services/ad.service";
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {AdRequestDTO} from "../../../models/dto/Ad/adRequestDTO.model";

@Component({
  selector: 'app-ad-view',
  templateUrl: './ad-view.component.html',
  styleUrls: ['./ad-view.component.css']
})
export class AdViewComponent {

  constructor(private route:ActivatedRoute,
              private adService:AdService,
              private router: Router) {}

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

  follow() {
    this.route.params.subscribe(params => {
      const adId = params['id'];
      this.adService.Follow(adId)
        .subscribe({
          next: (data) => {
            this.router.navigate(['/Main']);
          },
          error: (error) => {
            console.log(error);
          },
          complete: () => {
            alert("Ad has been successfully added to the list of ads you are following")
            this.router.navigate(['/Main'])
          }
        })
    })


  }


}
