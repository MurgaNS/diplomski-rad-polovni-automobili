package ftn.graduatethesispolovniautomobili.model.dto.car.request;

import ftn.graduatethesispolovniautomobili.model.enumeration.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CarRequestDTO {

    @NotEmpty(message = "Car category can not be empty")
    private ECarCategory carCategory;

    @NotEmpty(message = "Car drive can not be empty")
    private ECarDrive carDrive;

    @NotEmpty(message = "Car gearbox can not be empty")
    private ECarGearbox carGearbox;

    @NotEmpty(message = "Steering wheel side can not be empty")
    private ESteeringWheelSide steeringWheelSide;

    @NotEmpty(message = "Climate can not be empty")
    private EClimate climate;

    @NotEmpty(message = "Interior material can not be empty")
    private EInteriorMaterial interiorMaterial;

    @NotEmpty(message = "Car damage can not be empty")
    private ECarDamage damage;

    @NotEmpty(message = "Exchange can not be empty")
    private EExchange exchange;

    private List<ECarSafety> carSafety;

    private List<EVehicleCondition> vehicleCondition;

    private List<EAdditionalEquipment> additionalEquipment;

    @NotEmpty(message = "Photos can not be empty")
    private List<String> photos;

    @NotEmpty(message = "Brand can not be empty")
    private String brand;

    @NotEmpty(message = "Model can not be empty")
    private String model;

    @NotNull(message = "Please enter number of doors")
    private Integer doorNumber;

    @NotNull(message = "Please enter number of seats")
    private Integer seatsNumber;

    @NotEmpty(message = "Car color can not be empty")
    private String color;

    @NotEmpty(message = "Interior color can not be empty")
    private String interiorColor;

    private Date registeredUntil;

    @NotEmpty(message = "Chasis number can not be empty")
    private String chassisNumber;

    @NotEmpty(message = "Engine type can not be empty")
    private String engineType;

    @NotNull(message = "Please enter engine cubicle")
    private Integer engineCubicle;

    @NotNull(message = "Please enter engine power")
    private Integer power;

    @NotNull(message = "Please enter mileage")
    private Integer mileage;

    @NotEmpty(message = "Engine emmission class can not be empty")
    private EEngineEmmisionClass engineEmmisionClass;

    @NotEmpty(message = "Fuel type can not be empty")
    private EFuelType fuelType;

    private Boolean isRegistered;

}
