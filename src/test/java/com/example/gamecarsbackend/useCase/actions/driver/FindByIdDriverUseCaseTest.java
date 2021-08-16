package com.example.gamecarsbackend.useCase.actions.driver;

import com.example.gamecarsbackend.domain.entitys.Driver.Driver;
import com.example.gamecarsbackend.dto.DriverDTO;
import com.example.gamecarsbackend.repository.DriverRepository;
import com.example.gamecarsbackend.useCase.query.FindByIdDriverUseCase;
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
class FindByIdDriverUseCaseTest {
    @SpyBean
    FindByIdDriverUseCase findByIdDriverUseCase;

    @MockBean
    DriverRepository driverRepository;

    @Test
    void findByIdDriver(){
        var driverDTO = new DriverDTO("4",6 ,"8","9","1");
        var driver = new Driver();
        driver.setDriverId("4");
        driver.setPosition(6);
        driver.setLaneId("8");
        driver.setCarId("9");
        driver.setPlayerId("1");


        when(driverRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(driver));

        var response = findByIdDriverUseCase.findById(driverDTO.getDriverId());

        Assertions.assertEquals(response.block().getDriverId(), "4");
    }
}