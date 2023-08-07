import {Component, Input} from '@angular/core';
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {ReportResponseDTO} from "../../../models/dto/Report/reportResponseDTO.model";

@Component({
  selector: 'app-reported-ad-item',
  templateUrl: './reported-ad-item.component.html',
  styleUrls: ['./reported-ad-item.component.css']
})
export class ReportedAdItemComponent {

  @Input() reportedAd: ReportResponseDTO = new ReportResponseDTO();



}
