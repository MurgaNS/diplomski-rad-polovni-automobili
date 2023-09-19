import {Component, Input} from '@angular/core';
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";

@Component({
  selector: 'app-ad-list',
  templateUrl: './ad-list.component.html',
  styleUrls: ['./ad-list.component.css']
})
export class AdListComponent {

  @Input() ads: AdResponseDTO[] = [];


}
