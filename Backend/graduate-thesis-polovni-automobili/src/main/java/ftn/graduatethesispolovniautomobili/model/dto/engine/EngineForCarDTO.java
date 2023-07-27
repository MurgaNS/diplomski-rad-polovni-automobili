package ftn.graduatethesispolovniautomobili.model.dto.engine;

import ftn.graduatethesispolovniautomobili.model.enumeration.EEngineEmmisionClass;
import ftn.graduatethesispolovniautomobili.model.enumeration.EFuelType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EngineForCarDTO {

    private EFuelType fuelType;
    private EEngineEmmisionClass engineEmmisionClass;
    private String engineType;
    private Integer engineCubicle;
    private Integer power;
    private Integer mileage;
}
