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

  submitted: boolean = false;

  additionalEquipment: string[] = ["MULTIMEDIA", "MATRIX_LIGHTS"];
  selectedEquipment: string = '';
  selectedEquipments: string[] = [];

  onSelectionChangeEquipment() {
    if (this.selectedEquipment && !this.selectedEquipments.includes(this.selectedEquipment)) {
      this.selectedEquipments.push(this.selectedEquipment);
    }
    this.selectedEquipment = ''; // Clear the selected item after adding
  }

  vehicleCondition: string[] = ["GARAGED", "FIRST_OWNER"];
  selectedCondition: string = '';
  selectedConditions: string[] = [];

  onSelectionChangeVehicleCondition(){
    if (this.selectedCondition && !this.selectedConditions.includes(this.selectedCondition)) {
      this.selectedConditions.push(this.selectedCondition);
    }
    this.selectedCondition = ''; // Clear the selected item after adding
  }

  carSafety: string[] = ["ABS", "ALARM"];
  selectedCarSafety: string = '';
  selectedCarSafetys: string[] = [];

  onSelectionChangeCarSafety(){
    if (this.selectedCarSafety && !this.selectedCarSafetys.includes(this.selectedCarSafety)) {
      this.selectedCarSafetys.push(this.selectedCarSafety);
    }
    this.selectedCarSafety = ''; // Clear the selected item after adding
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
    carSafety: new FormControl(this.additionalEquipment),
    vehicleCondition: new FormControl(''),
    additionalEquipment: new FormControl(''),

  });


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

    addAd.carRequestDTO.additionalEquipment = this.selectedEquipments;
    addAd.carRequestDTO.vehicleCondition = this.selectedConditions;
    addAd.carRequestDTO.carSafety = this.selectedCarSafetys;

    addAd.description = this.adForm.get("description")?.value;

    this.adService.CreateAd(addAd)
      .subscribe({
        next: (data) => {
          this.router.navigate(['/Main']);
          console.log(this.selectedEquipments)
          console.log(this.selectedConditions)
          console.log(this.selectedCarSafetys)
        },
        error: (error) => {
          console.log(error);
          console.log(this.selectedEquipments)
          console.log(this.selectedConditions)
          console.log(this.selectedCarSafetys)

        },
        complete: () => {
          this.router.navigate(['/Main'])
          console.log(this.selectedEquipments)
          console.log(this.selectedConditions)
          console.log(this.selectedCarSafetys)
        }
      })


  }

  ngOnInit(): void {
  }

}
