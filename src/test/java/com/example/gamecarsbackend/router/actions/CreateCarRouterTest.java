package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.router.query.GetCarByGameIdRouter;
import com.example.gamecarsbackend.useCase.actions.CreateCarUseCase;
import com.example.gamecarsbackend.useCase.query.GetCarByGameIdUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CreateCarRouter.class})
class CreateCarRouterTest {
    @MockBean
    private CreateCarUseCase createCarUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createCar(){
        CarDTO carDTO = new CarDTO("8", false, 1, 3, "444", "444", "44444", "a");

        when(createCarUseCase.createCar(carDTO)).thenReturn(Mono.just(carDTO));

        webTestClient.post().uri("/car/create")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(carDTO), CarDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(CarDTO.class)
                .value(userResponse ->{
                    Assertions.assertThat(userResponse.getCarId()).isEqualTo(carDTO.getCarId());
                });
    }
}

