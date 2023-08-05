import {Component, Input} from '@angular/core';
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {ReportResponseDTO} from "../../../models/dto/Report/reportResponseDTO.model";

@Component({
  selector: 'app-reported-ad-list',
  templateUrl: './reported-ad-list.component.html',
  styleUrls: ['./reported-ad-list.component.css']
})
export class ReportedAdListComponent {

  @Input() reportedAds: ReportResponseDTO[] = [];

}
