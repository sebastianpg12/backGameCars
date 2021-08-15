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

import static org.mockito.Mockito.when;


@SpringBootTest
class EditCarUseCaseTest {
    @SpyBean
    EditCarUseCase editCarUseCase;

    @MockBean
    CarRepository carRepository;

    @Test
    void editCar(){
        var carDTO = new CarDTO("8", false, 9, 2, "1", "44", "44");
        var car = new Car();
        car.setCarId("8");
        car.setGoal(false);
        car.setCurrentPosition(9);
        car.setAdvance(2);
        car.setDriverId("1");
        car.setGameId("44");
        car.setLaneId("44");

        when(carRepository.save(Mockito.any(Car.class))).thenReturn(Mono.just(car));

        var response = editCarUseCase.modifyCar(carDTO);

        Assertions.assertEquals(response.block(), carDTO);

    }
}