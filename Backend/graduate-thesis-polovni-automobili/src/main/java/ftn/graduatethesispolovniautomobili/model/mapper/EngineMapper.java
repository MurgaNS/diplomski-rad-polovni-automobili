package ftn.graduatethesispolovniautomobili.model.mapper;

import ftn.graduatethesispolovniautomobili.model.dto.engine.EngineForCarDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Engine;

public class EngineMapper {

    public static EngineForCarDTO toDTO(Engine engine){

        EngineForCarDTO engineForCarDTO = new EngineForCarDTO();

        engineForCarDTO.setFuelType(engine.getFuelType());
        engineForCarDTO.setEngineEmmisionClass(engine.getEngineEmmisionClass());
        engineForCarDTO.setEngineType(engine.getEngineType());
        engineForCarDTO.setEngineCubicle(engine.getEngineCubicle());
        engineForCarDTO.setPower(engine.getPower());
        engineForCarDTO.setMileage(engine.getMileage());

        return engineForCarDTO;
    }

    public static Engine mapToEngine(EngineForCarDTO engineForCarDTO){

        Engine engine = new Engine();

        engine.setFuelType(engineForCarDTO.getFuelType());
        engine.setEngineEmmisionClass(engineForCarDTO.getEngineEmmisionClass());
        engine.setEngineType(engineForCarDTO.getEngineType());
        engine.setEngineCubicle(engineForCarDTO.getEngineCubicle());
        engine.setPower(engineForCarDTO.getPower());
        engine.setMileage(engineForCarDTO.getMileage());

        return engine;
    }

    public static Engine mapForUpdate(Engine engine, EngineForCarDTO engineForCarDTO){

        engine.setFuelType(engineForCarDTO.getFuelType());
        engine.setEngineEmmisionClass(engineForCarDTO.getEngineEmmisionClass());
        engine.setEngineType(engineForCarDTO.getEngineType());
        engine.setEngineCubicle(engineForCarDTO.getEngineCubicle());
        engine.setPower(engineForCarDTO.getPower());
        engine.setMileage(engineForCarDTO.getMileage());

        return engine;
    }


}
