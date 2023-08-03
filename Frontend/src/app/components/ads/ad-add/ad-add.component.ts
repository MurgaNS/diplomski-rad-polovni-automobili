import {Component} from '@angular/core';
import {AdService} from "../../../services/ad.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {AdRequestDTO} from "../../../models/dto/Ad/adRequestDTO.model";

@Component({
  selector: 'app-ad-add',
  templateUrl: './ad-add.component.html',
  styleUrls: ['./ad-add.component.css']
})
export class AdAddComponent {

  constructor(private adService: AdService,
              private router: Router) {
  }

  adForm: FormGroup = new FormGroup({
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
    chassisNumber: new FormControl(''),
    description: new FormControl(''),
    carSafety: new FormControl(''),
    vehicleCondition: new FormControl(''),
    additionalEquipment: new FormControl(''),


  });

  submitted: boolean = false;

  onSubmit() {

    this.submitted = true;
    if (this.adForm.invalid) {
      return;
    }

    let addAd: AdRequestDTO = new AdRequestDTO();
    addAd.price = this.adForm.get("price")?.value;
    addAd.carRequestDTO.brand = this.adForm.get("brand")?.value;
    addAd.carRequestDTO.model = this.adForm.get("model")?.value;
    addAd.carRequestDTO.mileage = this.adForm.get("mileage")?.value;
    addAd.carRequestDTO.carCategory = this.adForm.get("carCategory")?.value;
    addAd.carRequestDTO.engineType = this.adForm.get("engineType")?.value;
    addAd.carRequestDTO.fuelType = this.adForm.get("fuelType")?.value;
    addAd.carRequestDTO.engineCubicle = this.adForm.get("engineCubicle")?.value;
    addAd.carRequestDTO.power = this.adForm.get("power")?.value;
    addAd.carRequestDTO.exchange = this.adForm.get("exchange")?.value;
    addAd.carRequestDTO.engineEmmisionClass = this.adForm.get("engineEmmisionClass")?.value;
    addAd.carRequestDTO.carDrive = this.adForm.get("carDrive")?.value;
    addAd.carRequestDTO.carGearbox = this.adForm.get("carGearbox")?.value;
    addAd.carRequestDTO.doorNumber = this.adForm.get("doorNumber")?.value;
    addAd.carRequestDTO.seatsNumber = this.adForm.get("seatsNumber")?.value;
    addAd.carRequestDTO.steeringWheelSide = this.adForm.get("steeringWheelSide")?.value;
    addAd.carRequestDTO.climate = this.adForm.get("climate")?.value;
    addAd.carRequestDTO.color = this.adForm.get("color")?.value;
    addAd.carRequestDTO.interiorMaterial = this.adForm.get("interiorMaterial")?.value;
    addAd.carRequestDTO.interiorColor = this.adForm.get("interiorColor")?.value;
    addAd.carRequestDTO.registeredUntil = this.adForm.get("registeredUntil")?.value;
    addAd.carRequestDTO.damage = this.adForm.get("damage")?.value;
    addAd.carRequestDTO.chassisNumber = this.adForm.get("chassisNumber")?.value;
    addAd.carRequestDTO.carSafety = this.adForm.get("carSafety")?.value;
    addAd.carRequestDTO.vehicleCondition = this.adForm.get("vehicleCondition")?.value;
    addAd.carRequestDTO.additionalEquipment = this.adForm.get("additionalEquipment")?.value;
    addAd.description = this.adForm.get("description")?.value;

    this.adService.CreateAd(addAd)
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


  }

  ngOnInit(): void {
  }

}
