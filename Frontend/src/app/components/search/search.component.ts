import {Component, EventEmitter, Output} from '@angular/core';
import {AdRequestDTO} from "../../models/dto/Ad/adRequestDTO.model";
import {FormControl, FormGroup} from "@angular/forms";
import {AdService} from "../../services/ad.service";
import {Router} from "@angular/router";
import {AdResponseDTO} from "../../models/dto/Ad/adResponseDTO.model";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  @Output()
  newAdsEvent = new EventEmitter<AdResponseDTO[]>();

  constructor(private adService: AdService,
              private router: Router) {
  }

  submitted: boolean = false;

  adSearchForm: FormGroup = new FormGroup({
    priceFrom: new FormControl(null),
    priceTo: new FormControl(null),
    brand: new FormControl(null),
    model: new FormControl(null),
    mileageFrom: new FormControl(null),
    mileageTo: new FormControl(null),
    carCategory: new FormControl(null),
    engineType: new FormControl(null),
    fuelType: new FormControl(null),
    engineCubicleFrom: new FormControl(null),
    engineCubicleTo: new FormControl(null),
    powerFrom: new FormControl(null),
    powerTo: new FormControl(null),
    exchange: new FormControl(null),
    engineEmmisionClass: new FormControl(null),
    carDrive: new FormControl(null),
    carGearbox: new FormControl(null),
    doorNumber: new FormControl(null),
    seatsNumber: new FormControl(null),
    steeringWheelSide: new FormControl(null),
    climate: new FormControl(null),
    color: new FormControl(null),
    interiorMaterial: new FormControl(null),
    interiorColor: new FormControl(null),
    registeredUntil: new FormControl(null),
    damage: new FormControl(null),
  });

  onSubmit() {

    this.submitted = true;

    let searchAd: AdRequestDTO = new AdRequestDTO();
    searchAd.priceFrom = this.adSearchForm.get("priceFrom")?.value;
    searchAd.priceTo = this.adSearchForm.get("priceTo")?.value;
    searchAd.carRequestDTO.brand = this.adSearchForm.get("brand")?.value;
    searchAd.carRequestDTO.model = this.adSearchForm.get("model")?.value;
    searchAd.carRequestDTO.mileageFrom = this.adSearchForm.get("mileageFrom")?.value;
    searchAd.carRequestDTO.mileageTo = this.adSearchForm.get("mileageTo")?.value;
    searchAd.carRequestDTO.carCategory = this.adSearchForm.get("carCategory")?.value;
    searchAd.carRequestDTO.engineType = this.adSearchForm.get("engineType")?.value;
    searchAd.carRequestDTO.fuelType = this.adSearchForm.get("fuelType")?.value;
    searchAd.carRequestDTO.engineCubicleFrom = this.adSearchForm.get("engineCubicleFrom")?.value;
    searchAd.carRequestDTO.engineCubicleTo = this.adSearchForm.get("engineCubicleTo")?.value;
    searchAd.carRequestDTO.powerFrom = this.adSearchForm.get("powerFrom")?.value;
    searchAd.carRequestDTO.powerTo = this.adSearchForm.get("powerTo")?.value;
    searchAd.carRequestDTO.exchange = this.adSearchForm.get("exchange")?.value;
    searchAd.carRequestDTO.engineEmmisionClass = this.adSearchForm.get("engineEmmisionClass")?.value;
    searchAd.carRequestDTO.carDrive = this.adSearchForm.get("carDrive")?.value;
    searchAd.carRequestDTO.carGearbox = this.adSearchForm.get("carGearbox")?.value;
    searchAd.carRequestDTO.doorNumber = this.adSearchForm.get("doorNumber")?.value;
    searchAd.carRequestDTO.seatsNumber = this.adSearchForm.get("seatsNumber")?.value;
    searchAd.carRequestDTO.steeringWheelSide = this.adSearchForm.get("steeringWheelSide")?.value;
    searchAd.carRequestDTO.climate = this.adSearchForm.get("climate")?.value;
    searchAd.carRequestDTO.color = this.adSearchForm.get("color")?.value;
    searchAd.carRequestDTO.interiorMaterial = this.adSearchForm.get("interiorMaterial")?.value;
    searchAd.carRequestDTO.interiorColor = this.adSearchForm.get("interiorColor")?.value;
    searchAd.carRequestDTO.damage = this.adSearchForm.get("damage")?.value;
    // addAd.carRequestDTO.isRegistered = this.isRegistered;
    console.log(JSON.stringify(searchAd))
    this.adService.Search(searchAd)
      .subscribe({
        next: (data) => {
          this.newAdsEvent.emit(data);
          console.log(JSON.stringify(data))
        },
        error: (error) => {
          console.log(error);
        },
        complete: () => {
          this.router.navigate(['/Main'])
        }
      })
  }

  isShowDivSearch: boolean = false;

  toggleDisplayDivSearch(){
    this.isShowDivSearch = !this.isShowDivSearch

  }

}
