import {CarRequestDTO} from "../Car/carRequestDTO.model";

export class AdRequestDTO {
  price: number = 0;
  priceFrom: number = 0;
  priceTo: number = 0;
  description: string = "";
  carRequestDTO: CarRequestDTO = new CarRequestDTO();

}
