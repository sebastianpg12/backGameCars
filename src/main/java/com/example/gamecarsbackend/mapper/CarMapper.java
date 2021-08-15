package com.example.gamecarsbackend.mapper;

import com.example.gamecarsbackend.domain.entitys.Car.Car;
import com.example.gamecarsbackend.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarMapper {

    public Function<CarDTO, Car> mapperToCar(String id) {
        return updateCar -> {
            Car car = new Car();
            car.setId(updateCar.getId());
            car.setGoal(updateCar.getGoal());
            car.setCurrentPosition(updateCar.getCurrentPosition());
            car.setAdvance(updateCar.getAdvance());
            car.setDriverId(updateCar.getDriverId());
            car.setGameId(updateCar.getGameId());
            car.setLaneId(updateCar.getLaneId());
            return car;
        };

    }

    public Function<Car, CarDTO> mappertoCarDTO(){
        return car -> new CarDTO(
                car.getId(),
                car.getGoal(),
                car.getCurrentPosition(),
                car.getAdvance(),
                car.getDriverId(),
                car.getGameId(),
                car.getLaneId()
        );
    }

}
