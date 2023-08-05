import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AdService} from "../../../services/ad.service";
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {FormControl, FormGroup} from "@angular/forms";
import {ReportRequestDTO} from "../../../models/dto/Report/reportRequestDTO.model";
import {ReportService} from "../../../services/report.service";
import {AdChangeStatusDTO} from "../../../models/dto/Ad/adChangeStatusDTO.model";

@Component({
  selector: 'app-ad-view',
  templateUrl: './ad-view.component.html',
  styleUrls: ['./ad-view.component.css']
})
export class AdViewComponent {

  constructor(private route: ActivatedRoute,
              private adService: AdService,
              private reportService: ReportService,
              private router: Router) {
  }

  ad_id = Number(this.route.snapshot.paramMap.get("id"))
  ad: AdResponseDTO = new AdResponseDTO();
  adChangeStatus : AdChangeStatusDTO =new AdChangeStatusDTO();


  ngOnInit(): void {
    console.log(this.ad_id)
    this.adService.GetById(this.ad_id)
      .subscribe({
        next: (data) => {
          this.ad = data
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

  isShowDivIf = false;

  toggleDisplayDivIf() {
    this.isShowDivIf = !this.isShowDivIf;
  }

  reportForm: FormGroup = new FormGroup({
    reportReason: new FormControl(''),
  });

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
  deleteAd(){
    this.adChangeStatus.status = "DELETED";
    this.route.params.subscribe(params => {
      const adId = params['id'];
      this.adService.ChangeStatus(adId, this.adChangeStatus)
        .subscribe({
          next: (data) => {
            this.router.navigate(['/Reported-Ads']);
          },
          error: (error) => {
            console.log(error);
          },
          complete: () => {
            alert("Ad has been successfully deleted")
            this.router.navigate(['/Reported-Ads'])
          }
        })
    })
  }


}
