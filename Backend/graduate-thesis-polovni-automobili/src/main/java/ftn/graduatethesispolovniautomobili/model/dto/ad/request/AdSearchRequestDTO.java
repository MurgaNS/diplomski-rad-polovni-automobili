package ftn.graduatethesispolovniautomobili.model.dto.ad.request;

import ftn.graduatethesispolovniautomobili.model.dto.car.request.CarSearchRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdSearchRequestDTO {

    private Double priceFrom;
    private Double priceTo;
    private String description;
    private CarSearchRequestDTO carRequestDTO;

}
