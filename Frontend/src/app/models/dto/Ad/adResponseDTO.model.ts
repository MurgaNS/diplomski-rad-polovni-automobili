import {CarResponseDTO} from "../Car/carResponseDTO.model";
import {UserResponseDTO} from "../User/userResponseDTO.model";

export class AdResponseDTO {

  id: number = 0;
  price: number = 0;
  description: string = "";
  status: string = "";
  carResponseDTO: CarResponseDTO = new CarResponseDTO();
  user: UserResponseDTO = new UserResponseDTO();

}
