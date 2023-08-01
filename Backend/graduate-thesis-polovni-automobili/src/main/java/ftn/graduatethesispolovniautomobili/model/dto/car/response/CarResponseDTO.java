package ftn.graduatethesispolovniautomobili.model.dto.car.response;

import ftn.graduatethesispolovniautomobili.model.enumeration.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CarResponseDTO {

    private ECarCategory carCategory;
    private ECarDrive carDrive;
    private ECarGearbox carGearbox;
    private ESteeringWheelSide steeringWheelSide;
    private EClimate climate;
    private EInteriorMaterial interiorMaterial;
    private ECarDamage damage;
    private EExchange exchange;
    private ECarSafety carSafety;
    private EVehicleCondition vehicleCondition;
    private EAdditionalEquipment additionalEquipment;
    private List<String> photos;
    private String brand;
    private String model;
    private Integer doorNumber;
    private Integer seatsNumber;
    private String color;
    private String interiorColor;
    private Date registeredUntil;
    private String chassisNumber;
    private String engineType;
    private Integer engineCubicle;
    private Integer power;
    private Integer mileage;
    private EEngineEmmisionClass engineEmmisionClass;
    private EFuelType fuelType;

}
