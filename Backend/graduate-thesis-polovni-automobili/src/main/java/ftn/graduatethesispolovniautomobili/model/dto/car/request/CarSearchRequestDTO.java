package ftn.graduatethesispolovniautomobili.model.dto.car.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarSearchRequestDTO {


    private String carCategory;

    private String carDrive;

    private String carGearbox;

    private String steeringWheelSide;

    private String climate;

    private String interiorMaterial;

    private String damage;

    private String exchange;

    private String brand;

    private String model;

    private Integer doorNumber;

    private Integer seatsNumber;

    private String color;

    private String interiorColor;

    private Date registeredUntil;

    private String engineType;

    private Integer engineCubicle;

    private Integer power;

    private Integer mileage;

    private String engineEmmisionClass;

    private String fuelType;

}
