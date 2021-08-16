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
class GetCarByGameIdUseCaseTest {

    @SpyBean
    GetCarByGameIdUseCase getCarByGameIdUseCase;

    @MockBean
    CarRepository carRepository;

    @Test
    void findCarByIdDriver() {
        CarDTO carDTO = new CarDTO("8", true, 9, 2, "4", "5", "6","Ana");
        Car car = new Car();
        car.setCarId("8");
        car.setGoal(true);
        car.setCurrentPosition(9);
        car.setAdvance(2);
        car.setDriverId("4");
        car.setGameId("5");
        car.setLaneId("6");
        car.setNamePlayer("Ana");

        when(carRepository.findByGameId(Mockito.any(String.class))).thenReturn(Flux.just(car));

        Flux<CarDTO> response =getCarByGameIdUseCase.findCarsByGameId(carDTO.getGameId());

        Assertions.assertEquals(response.blockFirst().getGameId(), "5");
    }
}