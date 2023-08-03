import {CarRequestDTO} from "../Car/carRequestDTO.model";

export class AdRequestDTO {

  price: number = 0;
  description: string = "";
  carRequestDTO: CarRequestDTO = new CarRequestDTO();


  AdRequestDTO(price: number, description: string, carRequestDTO: CarRequestDTO) {
    this.price = price;
    this.description = description;
    this.carRequestDTO = carRequestDTO;
  }
}
