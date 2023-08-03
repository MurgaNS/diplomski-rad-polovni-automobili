import {Component, Input} from '@angular/core';
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";

@Component({
  selector: 'app-ad-item',
  templateUrl: './ad-item.component.html',
  styleUrls: ['./ad-item.component.css']
})
export class AdItemComponent {

  @Input() ad: AdResponseDTO = new AdResponseDTO();


}
