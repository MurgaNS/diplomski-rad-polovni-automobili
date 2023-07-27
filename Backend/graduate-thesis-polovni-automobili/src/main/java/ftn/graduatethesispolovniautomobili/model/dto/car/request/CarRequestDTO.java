package ftn.graduatethesispolovniautomobili.model.dto.car.request;

import ftn.graduatethesispolovniautomobili.model.dto.engine.EngineForCarDTO;
import ftn.graduatethesispolovniautomobili.model.enumeration.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarRequestDTO {

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
    private String photo;
    private String brand;
    private String model;
    private Integer doorNumber;
    private Integer seatsNumber;
    private String color;
    private String interiorColor;
    private Date registeredUntil;
    private String chassisNumber;
    private EngineForCarDTO engineForCarDTO;
}
