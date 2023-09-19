import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AdService} from "../../../services/ad.service";
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {FormControl, FormGroup} from "@angular/forms";
import {ReportRequestDTO} from "../../../models/dto/Report/reportRequestDTO.model";
import {ReportService} from "../../../services/report.service";
import {AdChangeStatusDTO} from "../../../models/dto/Ad/adChangeStatusDTO.model";
import {AuthenticationService} from "../../../security/authentication/authentication.service";
import {JwtUtilsService} from "../../../security/authentication/jwt-utils.service";

@Component({
  selector: 'app-ad-view',
  templateUrl: './ad-view.component.html',
  styleUrls: ['./ad-view.component.css']
})
export class AdViewComponent {

  constructor(private route: ActivatedRoute,
              private adService: AdService,
              private reportService: ReportService,
              private authService: AuthenticationService,
              private router: Router,
              private jwtUtilsService: JwtUtilsService,
  ) {
  }

  ad_id = Number(this.route.snapshot.paramMap.get("id"))
  ad: AdResponseDTO = new AdResponseDTO();
  adChangeStatus: AdChangeStatusDTO = new AdChangeStatusDTO();
  images: Array<object> = [];

  ngOnInit(): void {
    console.log(this.ad_id)
    this.adService.GetById(this.ad_id)
      .subscribe({
        next: (data) => {
          this.ad = data
          for (let photo of data.carResponseDTO.photos) {
            this.images.push({image: 'assets/images/' + photo, thumbImage: "assets/images/" + photo})
          }

        }
      })
  }

  reportForm: FormGroup = new FormGroup({
    reportReason: new FormControl(''),
  });

  rejectForm: FormGroup = new FormGroup({
    rejectedReason: new FormControl(''),
  });

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

  isShowDivIf = false;

  toggleDisplayDivIf() {
    this.isShowDivIf = !this.isShowDivIf;
  }

  isShowDivReject: boolean = false;

  toggleDisplayDivReject() {
    this.isShowDivReject = !this.isShowDivReject

  }

  report() {

    let addReport: ReportRequestDTO = new ReportRequestDTO();
    addReport.reportReason = this.reportForm.get("reportReason")?.value;

    this.route.params.subscribe(params => {
      const adId = params['id'];
      this.reportService.Report(adId, addReport)
        .subscribe({
          next: (data) => {
            this.router.navigate(['/Main']);
          },
          error: (error) => {
            console.log(error);
          },
          complete: () => {
            alert("Ad has been successfully reported")
            this.router.navigate(['/Main'])
          }
        })
    })

  }

  deleteAd() {
    this.adChangeStatus.status = "DELETED";
    this.route.params.subscribe(params => {
      const adId = params['id'];
      this.adService.ChangeStatus(adId, this.adChangeStatus)
        .subscribe({
          next: (data) => {
            this.router.navigate(['/Main']);
          },
          error: (error) => {
            console.log(error);
          },
          complete: () => {
            alert("Ad has been successfully deleted")
            this.router.navigate(['/Main'])
          }
        })
    })
  }

  approveAd() {
    this.adChangeStatus.status = "ACTIVE";
    this.route.params.subscribe(params => {
      const adId = params['id'];
      this.adService.ChangeStatus(adId, this.adChangeStatus)
        .subscribe({
          next: (data) => {
            this.router.navigate(['/Main']);
          },
          error: (error) => {
            console.log(error);
          },
          complete: () => {
            alert("Ad has been successfully approved.")
            this.router.navigate(['/Main'])
          }
        })
    })
  }

  rejectAd() {

    let adChangeStatus: AdChangeStatusDTO = new AdChangeStatusDTO();
    adChangeStatus.rejectedReason = this.rejectForm.get("rejectedReason")?.value;
    adChangeStatus.status = "REJECTED"

    this.route.params.subscribe(params => {
      const adId = params['id'];
      this.adService.ChangeStatus(adId, adChangeStatus)
        .subscribe({
          next: (data) => {
            this.router.navigate(['/Main']);
          },
          error: (error) => {
            console.log(error);
          },
          complete: () => {
            alert("Ad has been successfully rejected")
            this.router.navigate(['/Main'])
          }
        })
    })
  }

  hasLoggedIn() {
    return this.authService.hasLoggedIn();
  }

  isAdmin(): boolean {
    return this.jwtUtilsService.getRole(this.authService.getToken()) === "ROLE_ADMIN";
  }

  isRejectedOrApproved(): boolean {
    return this.ad.status !== 'ACTIVE';
  }

  isRegular(): boolean {
    return this.jwtUtilsService.getRole(this.authService.getToken()) === "ROLE_REGULAR";
  }

  isAdCreator() {
    return this.jwtUtilsService.getUsername(this.authService.getToken()) == this.ad.user.email;
  }

}
