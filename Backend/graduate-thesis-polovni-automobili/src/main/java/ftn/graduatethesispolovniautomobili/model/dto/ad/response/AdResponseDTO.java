package ftn.graduatethesispolovniautomobili.model.dto.ad.response;

import ftn.graduatethesispolovniautomobili.model.dto.car.response.CarResponseDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdResponseDTO {
    private Double price;
    private String description;
    private CarResponseDTO carResponseDTO;
    private UserDTO user;
}
