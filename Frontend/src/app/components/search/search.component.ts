import { Component } from '@angular/core';
import {AdRequestDTO} from "../../models/dto/Ad/adRequestDTO.model";
import {FormControl, FormGroup} from "@angular/forms";
import {AdService} from "../../services/ad.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  constructor(private adService: AdService,
              private router: Router) {
  }

  submitted: boolean = false;

  adSearchForm: FormGroup = new FormGroup({
    price: new FormControl(''),
    brand: new FormControl(''),
    model: new FormControl(''),
    mileage: new FormControl(''),
    carCategory: new FormControl(''),
    engineType: new FormControl(''),
    fuelType: new FormControl(''),
    engineCubicle: new FormControl(''),
    power: new FormControl(''),
    exchange: new FormControl(''),
    engineEmmisionClass: new FormControl(''),
    carDrive: new FormControl(''),
    carGearbox: new FormControl(''),
    doorNumber: new FormControl(''),
    seatsNumber: new FormControl(''),
    steeringWheelSide: new FormControl(''),
    climate: new FormControl(''),
    color: new FormControl(''),
    interiorMaterial: new FormControl(''),
    interiorColor: new FormControl(''),
    registeredUntil: new FormControl(''),
    damage: new FormControl(''),
  });

  onSubmit() {

    this.submitted = true;
    if (this.adSearchForm.invalid) {
      return;
    }

    let searchAd: AdRequestDTO = new AdRequestDTO();
    searchAd.price = this.adSearchForm.get("price")?.value;
    searchAd.carRequestDTO.brand = this.adSearchForm.get("brand")?.value;
    searchAd.carRequestDTO.model = this.adSearchForm.get("model")?.value;
    searchAd.carRequestDTO.mileage = this.adSearchForm.get("mileage")?.value;
    searchAd.carRequestDTO.carCategory = this.adSearchForm.get("carCategory")?.value;
    searchAd.carRequestDTO.engineType = this.adSearchForm.get("engineType")?.value;
    searchAd.carRequestDTO.fuelType = this.adSearchForm.get("fuelType")?.value;
    searchAd.carRequestDTO.engineCubicle = this.adSearchForm.get("engineCubicle")?.value;
    searchAd.carRequestDTO.power = this.adSearchForm.get("power")?.value;
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

    this.adService.Search(searchAd)
      .subscribe({
        next: (data) => {
          this.router.navigate(['/Main']);
        },
        error: (error) => {
          console.log(error);
        },
        complete: () => {
          this.router.navigate(['/Main'])
        }
      })

    console.log(searchAd)

  }

  isShowDivSearch: boolean = false;

  toggleDisplayDivSearch(){
    this.isShowDivSearch = !this.isShowDivSearch

  }

}
