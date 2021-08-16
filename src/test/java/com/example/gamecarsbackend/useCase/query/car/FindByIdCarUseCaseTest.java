package com.example.gamecarsbackend.useCase.query.car;

import com.example.gamecarsbackend.domain.entitys.Car.Car;
import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.repository.CarRepository;
import com.example.gamecarsbackend.useCase.query.FindByIdCarUseCase;
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
class FindByIdCarUseCaseTest {
    @SpyBean
    FindByIdCarUseCase findByIdCarUseCase;

    @MockBean
    CarRepository carRepository;

    @Test
    void findByIdPlayer() {
        var carDTO = new CarDTO("8", false, 3, 2, "1", "5", "5","a");
        var car = new Car();
        car.setCarId("8");
        car.setGoal(false);
        car.setCurrentPosition(3);
        car.setAdvance(2);
        car.setDriverId("1");
        car.setGameId("5");
        car.setLaneId("5");
        car.setNamePlayer("a");

        when(carRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(car));

        var response = findByIdCarUseCase.findById(carDTO.getCarId());

        Assertions.assertEquals(response.block().getCarId(), "8");
    }

}