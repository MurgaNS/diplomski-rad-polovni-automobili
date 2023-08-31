import {Component, EventEmitter, Input} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {AdRequestDTO} from "../../../models/dto/Ad/adRequestDTO.model";
import {AdService} from "../../../services/ad.service";
import {Ad} from "../../../models/ad.model";
import {AdResponseDTO} from "../../../models/dto/Ad/adResponseDTO.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.css']
})
export class AddEditComponent {

  constructor(private adService: AdService,
              private route: ActivatedRoute,
              private fb: FormBuilder,
              private router: Router) {
  }

  ad: AdResponseDTO = new AdResponseDTO();

  ad_id = Number(this.route.snapshot.paramMap.get("id"))

  newAdEvent = new EventEmitter<AdResponseDTO>();

  submitted = false;

  adEditForm: FormGroup = new FormGroup({
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

  fillFields() {
    this.adEditForm.patchValue(
      {
        price: this.ad.price,
        brand: this.ad.carResponseDTO.brand,
        model: this.ad.carResponseDTO.model,
        mileage: this.ad.carResponseDTO.mileage,
        carCategory: this.ad.carResponseDTO.carCategory,
        engineType: this.ad.carResponseDTO.engineType,
        fuelType: this.ad.carResponseDTO.fuelType,
        engineCubicle: this.ad.carResponseDTO.engineCubicle,
        power: this.ad.carResponseDTO.power,
        exchange: this.ad.carResponseDTO.exchange,
        engineEmmisionClass: this.ad.carResponseDTO.engineEmmisionClass,
        carDrive: this.ad.carResponseDTO.carDrive,
        carGearbox: this.ad.carResponseDTO.carGearbox,
        doorNumber: this.ad.carResponseDTO.doorNumber,
        seatsNumber: this.ad.carResponseDTO.seatsNumber,
        steeringWheelSide: this.ad.carResponseDTO.steeringWheelSide,
        climate: this.ad.carResponseDTO.climate,
        color: this.ad.carResponseDTO.color,
        interiorMaterial: this.ad.carResponseDTO.interiorMaterial,
        interiorColor: this.ad.carResponseDTO.interiorColor,
        registeredUntil: this.ad.carResponseDTO.registeredUntil,
        damage: this.ad.carResponseDTO.damage,
        chassisNumber: this.ad.carResponseDTO.chassisNumber,
        description: this.ad.description,
      },
    )
  }

  ngOnInit() {
    this.adService.GetById(this.ad_id)
      .subscribe({
        next: (data) => {
          this.ad = data
          this.fillFields();

          this.adEditForm.get("carSafety")?.setValue(data.carResponseDTO.carSafety);
          this.adEditForm.get("vehicleCondition")?.setValue(data.carResponseDTO.vehicleCondition);
          this.adEditForm.get("additionalEquipment")?.setValue(data.carResponseDTO.additionalEquipment);

          console.log(this.ad)
        }
      })
  }

  saveChanges() {
    this.submitted = true;
    if (this.adEditForm.invalid) {
      return;
    }
    let newAd = this.editAd();

    this.route.params.subscribe(params => {
      const adId = params['id'];
      this.adService.EditAd(newAd, adId).subscribe((ad) => {
          this.newAdEvent.emit(ad)
          this.router.navigate(['/Ad-View', this.ad_id])

        },
        (error) => {
          alert("Error changing ad, please try again")
        })
    })
  }


  editAd() {
    let editedAD = new AdRequestDTO();
    editedAD.price = this.adEditForm.get("price")?.value;
    editedAD.carRequestDTO.brand = this.adEditForm.get("brand")?.value;
    editedAD.carRequestDTO.model = this.adEditForm.get("model")?.value;
    editedAD.carRequestDTO.mileage = this.adEditForm.get("mileage")?.value;
    editedAD.carRequestDTO.carCategory = this.adEditForm.get("carCategory")?.value;
    editedAD.carRequestDTO.engineType = this.adEditForm.get("engineType")?.value;
    editedAD.carRequestDTO.fuelType = this.adEditForm.get("fuelType")?.value;
    editedAD.carRequestDTO.engineCubicle = this.adEditForm.get("engineCubicle")?.value;
    editedAD.carRequestDTO.power = this.adEditForm.get("power")?.value;
    editedAD.carRequestDTO.exchange = this.adEditForm.get("exchange")?.value;
    editedAD.carRequestDTO.engineEmmisionClass = this.adEditForm.get("engineEmmisionClass")?.value;
    editedAD.carRequestDTO.carDrive = this.adEditForm.get("carDrive")?.value;
    editedAD.carRequestDTO.carGearbox = this.adEditForm.get("carGearbox")?.value;
    editedAD.carRequestDTO.doorNumber = this.adEditForm.get("doorNumber")?.value;
    editedAD.carRequestDTO.seatsNumber = this.adEditForm.get("seatsNumber")?.value;
    editedAD.carRequestDTO.steeringWheelSide = this.adEditForm.get("steeringWheelSide")?.value;
    editedAD.carRequestDTO.climate = this.adEditForm.get("climate")?.value;
    editedAD.carRequestDTO.color = this.adEditForm.get("color")?.value;
    editedAD.carRequestDTO.interiorMaterial = this.adEditForm.get("interiorMaterial")?.value;
    editedAD.carRequestDTO.interiorColor = this.adEditForm.get("interiorColor")?.value;
    editedAD.carRequestDTO.registeredUntil = this.adEditForm.get("registeredUntil")?.value;
    editedAD.carRequestDTO.damage = this.adEditForm.get("damage")?.value;
    editedAD.carRequestDTO.chassisNumber = this.adEditForm.get("chassisNumber")?.value;
    editedAD.carRequestDTO.additionalEquipment = this.adEditForm.get("additionalEquipment")?.value;
    editedAD.carRequestDTO.vehicleCondition = this.adEditForm.get("vehicleCondition")?.value;
    editedAD.carRequestDTO.carSafety = this.adEditForm.get("carSafety")?.value;
    editedAD.description = this.adEditForm.value.description;

    return editedAD;
  }

  additionalEquipment: string[] = ["METALIC_COLOR", "MULTI_FUNCTIONAL_STEERING_WHEEL", "CRUISE_CONTROL", "REMOTE_LOCKING", "BLUETOOTH"
    , "CD_CHANGER", "CAMERA", "PANORAMIC_ROOF", "ELECTRIC_WINDOWS", "ELECTRIC_MIRRORS", "SEAT_HEATING", "SEAT_COOLING", "SEAT_MEMORY"
    , "MASSAGE_SEATS", "ISOFIX_SYSTEM", "MATRIX_LIGHTS", "MULTIMEDIA", "SPARE_WHEEL", "HILL_ASSIST"];
  selectedEquipment: string = '';
  selectedEquipments: string[] = [];

  onSelectionChangeEquipment() {
    if (this.selectedEquipment && !this.selectedEquipments.includes(this.selectedEquipment)) {
      this.selectedEquipments.push(this.selectedEquipment);
    }
    this.selectedEquipment = '';
  }

  vehicleCondition: string[] = ["GARAGED", "FIRST_OWNER", "UNDER_WARRANTY", "TEST_VEHICLE", "SERVICE_BOOK", "TAXI_VEHICLE"];
  selectedCondition: string = '';
  selectedConditions: string[] = [];

  onSelectionChangeVehicleCondition() {
    if (this.selectedCondition && !this.selectedConditions.includes(this.selectedCondition)) {
      this.selectedConditions.push(this.selectedCondition);
    }
    this.selectedCondition = '';
  }

  carSafety: string[] = ["ABS", "ALARM", "ASR", "DRIVER_AIRBAG", "PASSENGER_AIRBAR", "SIDE_AIRBAR", "CHILD_LOCK", "BLIND_SPOT_SENSOR"
    , "AUTOMATIC_BRAKING", "CAR_PROTECTION"];
  selectedCarSafety: string = '';
  selectedCarSafetys: string[] = [];

  onSelectionChangeCarSafety() {
    if (this.selectedCarSafety && !this.selectedCarSafetys.includes(this.selectedCarSafety)) {
      this.selectedCarSafetys.push(this.selectedCarSafety);
    }
    this.selectedCarSafety = '';
  }

}
