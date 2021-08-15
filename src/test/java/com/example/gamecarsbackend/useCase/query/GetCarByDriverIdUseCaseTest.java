package com.example.gamecarsbackend.useCase.query;

import com.example.gamecarsbackend.domain.entitys.Car.Car;
import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetCarByDriverIdUseCaseTest {

    @SpyBean
    GetCarByDriverIdUseCase getCarByDriverIdUseCase;

    @MockBean
    CarRepository carRepository;

    @Test
    void getByIdDriver() {
        var carDTO = new CarDTO("8", false, 3, 2, "1", "5", "5");
        var car = new Car();
        car.setCarId("8");
        car.setGoal(false);
        car.setCurrentPosition(3);
        car.setAdvance(2);
        car.setDriverId("1");
        car.setGameId("5");
        car.setLaneId("5");
        when(carRepository.findByDriverId(Mockito.any(String.class))).thenReturn(Flux.just(car));
        var response =getCarByDriverIdUseCase.findCarsByDriverId(carDTO.getCarId());
        Assertions.assertEquals(response.blockFirst().getDriverId(), "1");
    }

}