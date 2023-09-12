package ftn.graduatethesispolovniautomobili.model.dto.ad.request;

import ftn.graduatethesispolovniautomobili.model.dto.car.request.CarRequestDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AdRequestDTO {

    @NotEmpty(message = "Price can not be empty")
    private Double price;
    @NotEmpty(message = "Description can not be empty")
    private String description;
    @NotNull(message = "Please enter car fields")
    private CarRequestDTO carRequestDTO;



}
