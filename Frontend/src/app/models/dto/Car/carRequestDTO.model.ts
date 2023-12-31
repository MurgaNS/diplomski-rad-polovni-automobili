export class CarRequestDTO {

  carCategory: string = "";
  carDrive: string = "";
  carGearbox: string = "";
  steeringWheelSide: string = "";
  climate: string = "";
  interiorMaterial: string = "";
  damage: string = "";
  exchange: string = "";
  carSafety: string[] = [];
  vehicleCondition: string[] = [];
  additionalEquipment: string[] = [];
  fuelType: string = "";
  engineEmmisionClass: string = "";
  brand: string = "";
  model: string = "";
  doorNumber: number = 0;
  seatsNumber: number = 0;
  color: string = "";
  interiorColor: string = "";
  registeredUntil: Date | undefined;
  chassisNumber: string = "";
  engineType: string = "";
  engineCubicle: number = 0;
  engineCubicleFrom: number = 0;
  engineCubicleTo: number = 0;
  power: number = 0;
  powerFrom: number = 0;
  powerTo: number = 0;
  mileage: number = 0;
  mileageFrom: number = 0;
  mileageTo: number = 0;
  photos: string[] = [];
  isRegistered: boolean = true;


  CarRequestDTO(carCategory: string, carDrive: string, carGearbox: string, steeringWheelSide: string, climate: string, interiorMaterial: string, damage: string, exchange: string, carSafety: string[], vehicleCondition: string[], additionalEquipment: string[], fuelType: string, engineEmmisionClass: string, brand: string, model: string, doorNumber: number, seatsNumber: number, color: string, interiorColor: string, registeredUntil: Date, chassisNumber: string, engineType: string, engineCubicle: number, power: number, mileage: number, photos: string[], isRegistered: boolean) {
    this.carCategory = carCategory;
    this.carDrive = carDrive;
    this.carGearbox = carGearbox;
    this.steeringWheelSide = steeringWheelSide;
    this.climate = climate;
    this.interiorMaterial = interiorMaterial;
    this.damage = damage;
    this.exchange = exchange;
    this.carSafety = carSafety;
    this.vehicleCondition = vehicleCondition;
    this.additionalEquipment = additionalEquipment;
    this.fuelType = fuelType;
    this.engineEmmisionClass = engineEmmisionClass;
    this.brand = brand;
    this.model = model;
    this.doorNumber = doorNumber;
    this.seatsNumber = seatsNumber;
    this.color = color;
    this.interiorColor = interiorColor;
    this.registeredUntil = registeredUntil;
    this.chassisNumber = chassisNumber;
    this.engineType = engineType;
    this.engineCubicle = engineCubicle;
    this.power = power;
    this.mileage = mileage;
    this.photos = photos;
    this.isRegistered = isRegistered;
  }
}
