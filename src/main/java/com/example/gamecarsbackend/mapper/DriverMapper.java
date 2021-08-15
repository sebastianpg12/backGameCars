package com.example.gamecarsbackend.mapper;

import com.example.gamecarsbackend.domain.entitys.Driver.Driver;
import com.example.gamecarsbackend.dto.DriverDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DriverMapper {

    public Function<DriverDTO, Driver> mapperToDriver(String id){
        return updateDriver -> {
            Driver driver = new Driver();
            driver.setDriverId(id);
            driver.setPosition(updateDriver.getPosition());
            driver.setPlayerId(updateDriver.getPlayerId());
            driver.setLaneId(updateDriver.getLaneId());
            driver.setCarId(updateDriver.getCarId());
            return driver;
        };
    }

    public Function<Driver,DriverDTO> mapperToDriverDTO(){
        return driver -> new DriverDTO(
                driver.getDriverId(),
                driver.getPosition(),
                driver.getPlayerId(),
                driver.getLaneId(),
                driver.getCarId()
        );
    }
}