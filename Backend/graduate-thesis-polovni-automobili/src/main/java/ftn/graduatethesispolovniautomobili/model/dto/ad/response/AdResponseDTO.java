package ftn.graduatethesispolovniautomobili.model.dto.ad.response;

import ftn.graduatethesispolovniautomobili.model.dto.car.response.CarResponseDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.enumeration.EAdStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdResponseDTO {

    private Integer id;
    private Double price;
    private String description;
    private EAdStatus status;
    private CarResponseDTO carResponseDTO;
    private UserDTO user;
}
