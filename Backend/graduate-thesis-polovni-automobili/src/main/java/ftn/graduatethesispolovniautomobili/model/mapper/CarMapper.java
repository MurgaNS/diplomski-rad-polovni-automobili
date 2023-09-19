package ftn.graduatethesispolovniautomobili.model.mapper;

import ftn.graduatethesispolovniautomobili.model.dto.car.request.CarRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.car.response.CarResponseDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Car;
import ftn.graduatethesispolovniautomobili.model.enumeration.ECarCategory;

public class CarMapper {

    public static CarResponseDTO toDTO(Car car){

        CarResponseDTO carResponseDTO = new CarResponseDTO();

        carResponseDTO.setCarCategory(ECarCategory.valueOf(String.valueOf(car.getCarCategory())));
        carResponseDTO.setCarDrive(car.getCarDrive());
        carResponseDTO.setCarGearbox(car.getCarGearbox());
        carResponseDTO.setSteeringWheelSide(car.getSteeringWheelSide());
        carResponseDTO.setClimate(car.getClimate());
        carResponseDTO.setInteriorMaterial(car.getInteriorMaterial());
        carResponseDTO.setDamage(car.getDamage());
        carResponseDTO.setExchange(car.getExchange());
        carResponseDTO.setCarSafety(car.getCarSafety());
        carResponseDTO.setVehicleCondition(car.getVehicleCondition());
        carResponseDTO.setAdditionalEquipment(car.getAdditionalEquipment());
        carResponseDTO.setPhotos(car.getPhotos());
        carResponseDTO.setBrand(car.getBrand());
        carResponseDTO.setModel(car.getModel());
        carResponseDTO.setDoorNumber(car.getDoorNumber());
        carResponseDTO.setSeatsNumber(car.getSeatsNumber());
        carResponseDTO.setColor(car.getColor());
        carResponseDTO.setInteriorColor(car.getInteriorColor());
        carResponseDTO.setRegisteredUntil(car.getRegisteredUntil());
        carResponseDTO.setChassisNumber(car.getChassisNumber());
        carResponseDTO.setEngineType(car.getEngineType());
        carResponseDTO.setEngineCubicle(car.getEngineCubicle());
        carResponseDTO.setPower(car.getPower());
        carResponseDTO.setMileage(car.getMileage());
        carResponseDTO.setEngineEmmisionClass(car.getEngineEmmisionClass());
        carResponseDTO.setFuelType(car.getFuelType());
        carResponseDTO.setRegistered(car.isRegistered());

        return carResponseDTO;

    }
    public static Car mapToCar(CarRequestDTO carRequestDTO){

        Car car = new Car();

        car.setCarCategory(carRequestDTO.getCarCategory());
        car.setCarDrive(carRequestDTO.getCarDrive());
        car.setCarGearbox(carRequestDTO.getCarGearbox());
        car.setSteeringWheelSide(carRequestDTO.getSteeringWheelSide());
        car.setClimate(carRequestDTO.getClimate());
        car.setInteriorMaterial(carRequestDTO.getInteriorMaterial());
        car.setDamage(carRequestDTO.getDamage());
        car.setExchange(carRequestDTO.getExchange());
        car.setCarSafety(carRequestDTO.getCarSafety());
        car.setVehicleCondition(carRequestDTO.getVehicleCondition());
        car.setAdditionalEquipment(carRequestDTO.getAdditionalEquipment());
        car.setPhotos(carRequestDTO.getPhotos());
        car.setBrand(carRequestDTO.getBrand());
        car.setModel(carRequestDTO.getModel());
        car.setDoorNumber(carRequestDTO.getDoorNumber());
        car.setSeatsNumber(carRequestDTO.getSeatsNumber());
        car.setColor(carRequestDTO.getColor());
        car.setInteriorColor(carRequestDTO.getInteriorColor());
        car.setRegisteredUntil(carRequestDTO.getRegisteredUntil());
        car.setChassisNumber(carRequestDTO.getChassisNumber());
        car.setEngineType(carRequestDTO.getEngineType());
        car.setEngineCubicle(carRequestDTO.getEngineCubicle());
        car.setPower(carRequestDTO.getPower());
        car.setMileage(carRequestDTO.getMileage());
        car.setEngineEmmisionClass(carRequestDTO.getEngineEmmisionClass());
        car.setFuelType(carRequestDTO.getFuelType());
        car.setRegistered(carRequestDTO.getIsRegistered());

        return car;
    }

    public static Car mapForUpdate(Car car, CarRequestDTO carRequestDTO){

        car.setCarCategory(carRequestDTO.getCarCategory());
        car.setCarDrive(carRequestDTO.getCarDrive());
        car.setCarGearbox(carRequestDTO.getCarGearbox());
        car.setSteeringWheelSide(carRequestDTO.getSteeringWheelSide());
        car.setClimate(carRequestDTO.getClimate());
        car.setInteriorMaterial(carRequestDTO.getInteriorMaterial());
        car.setDamage(carRequestDTO.getDamage());
        car.setExchange(carRequestDTO.getExchange());
        car.setCarSafety(carRequestDTO.getCarSafety());
        car.setVehicleCondition(carRequestDTO.getVehicleCondition());
        car.setAdditionalEquipment(carRequestDTO.getAdditionalEquipment());
        car.setPhotos(carRequestDTO.getPhotos());
        car.setBrand(carRequestDTO.getBrand());
        car.setModel(carRequestDTO.getModel());
        car.setDoorNumber(carRequestDTO.getDoorNumber());
        car.setSeatsNumber(carRequestDTO.getSeatsNumber());
        car.setColor(carRequestDTO.getColor());
        car.setInteriorColor(carRequestDTO.getInteriorColor());
        car.setRegisteredUntil(carRequestDTO.getRegisteredUntil());
        car.setChassisNumber(carRequestDTO.getChassisNumber());
        car.setEngineType(carRequestDTO.getEngineType());
        car.setEngineCubicle(carRequestDTO.getEngineCubicle());
        car.setPower(carRequestDTO.getPower());
        car.setMileage(carRequestDTO.getMileage());
        car.setEngineEmmisionClass(carRequestDTO.getEngineEmmisionClass());
        car.setFuelType(carRequestDTO.getFuelType());
        car.setRegistered(carRequestDTO.getIsRegistered());

        return car;
    }

}
