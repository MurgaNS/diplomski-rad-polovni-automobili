package ftn.graduatethesispolovniautomobili.model.dto.ad.request;

import ftn.graduatethesispolovniautomobili.model.dto.car.request.CarRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdRequestDTO {

    private Double price;
    private String description;
    private CarRequestDTO carRequestDTO;



}
