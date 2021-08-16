package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.DriverDTO;
import com.example.gamecarsbackend.dto.DriverDTO;
import com.example.gamecarsbackend.useCase.actions.CreateCarUseCase;
import com.example.gamecarsbackend.useCase.actions.CreateDriverUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CreateDriverRouter.class})

class CreateDriverRouterTest {
    @MockBean
    private CreateDriverUseCase createDriverUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createDriver(){
        DriverDTO driverDTO = new DriverDTO("4",6 ,"8","9","1");

        when(createDriverUseCase.apply(driverDTO)).thenReturn(Mono.just(driverDTO));

        webTestClient.post().uri("/driver/create")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(driverDTO), DriverDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DriverDTO.class)
                .value(userResponse ->{
                    Assertions.assertThat(userResponse.getDriverId()).isEqualTo(driverDTO.getDriverId());
                });
    }

}