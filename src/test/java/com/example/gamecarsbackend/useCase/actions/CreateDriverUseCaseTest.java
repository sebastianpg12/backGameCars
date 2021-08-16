package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.domain.entitys.Driver.Driver;
import com.example.gamecarsbackend.dto.DriverDTO;
import com.example.gamecarsbackend.repository.DriverRepository;
import com.example.gamecarsbackend.useCase.actions.CreateDriverUseCase;
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
class CreateDriverUseCaseTest {

    @SpyBean
    CreateDriverUseCase createDriverUseCase;

    @MockBean
    DriverRepository driverRepository;

    @Test
    void createDriver(){
        DriverDTO driverDTO = new DriverDTO("4",6 ,"8","9","1");
        Driver driver = new Driver();
        driver.setDriverId("4");
        driver.setPosition(6);
        driver.setPlayerId("8");
        driver.setLaneId("9");
        driver.setCarId("1");

        when(driverRepository.save(Mockito.any(Driver.class))).thenReturn(Mono.just(driver));

        Mono<DriverDTO> response = createDriverUseCase.apply(driverDTO);

        Assertions.assertEquals(response.block(), driverDTO);
    }
}