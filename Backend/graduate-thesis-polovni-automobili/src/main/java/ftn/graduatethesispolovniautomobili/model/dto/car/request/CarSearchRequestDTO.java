package ftn.graduatethesispolovniautomobili.model.dto.car.request;

import ftn.graduatethesispolovniautomobili.model.enumeration.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarSearchRequestDTO {


    private ECarCategory carCategory;

    private ECarDrive carDrive;

    private ECarGearbox carGearbox;

    private ESteeringWheelSide steeringWheelSide;

    private EClimate climate;

    private EInteriorMaterial interiorMaterial;

    private ECarDamage damage;

    private EExchange exchange;

    private String brand;

    private String model;

    private Integer doorNumber;

    private Integer seatsNumber;

    private String color;

    private String interiorColor;

    private Date registeredUntil;

    private String engineType;

    private Integer engineCubicleFrom;
    private Integer engineCubicleTo;

    private Integer powerFrom;
    private Integer powerTo;

    private Integer mileageFrom;
    private Integer mileageTo;

    private EEngineEmmisionClass engineEmmisionClass;

    private EFuelType fuelType;

}
