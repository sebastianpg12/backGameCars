package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.domain.entitys.Car.Car;
import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreateCarUseCaseTest {

    @SpyBean
    CreateCarUseCase createCarUseCase;

    @MockBean
    CarRepository carRepository;

    @Test
    void createCar(){
        var carDTO = new CarDTO("8", false, 1, 3, "444", "444", "44444");
        var car = new Car();
        car.setCarId("8");
        car.setGoal(false);
        car.setCurrentPosition(1);
        car.setAdvance(3);
        car.setDriverId("444");
        car.setGameId("444");
        car.setLaneId("44444");


        when(carRepository.save(Mockito.any(Car.class))).thenReturn(Mono.just(car));

        var response = createCarUseCase.createCar(carDTO);

        Assertions.assertEquals(response.block(), carDTO);

    }
}