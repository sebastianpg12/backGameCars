package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.domain.entitys.Game.Player;
import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.router.query.GetCarByGameIdRouter;
import com.example.gamecarsbackend.router.query.GetPlayersByGameIdRouter;
import com.example.gamecarsbackend.useCase.actions.CreateCarUseCase;
import com.example.gamecarsbackend.useCase.actions.CreatePlayerUseCase;
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
@ContextConfiguration(classes = {CreatePlayerRouter.class})
class CreatePlayerRouterTest {

    @MockBean
    private CreatePlayerUseCase createPlayerUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createCar(){
        PlayerDTO playerDTO = new PlayerDTO("7", "Carlos", 0, 0, 0, "5", "7");

        when(createPlayerUseCase.apply(playerDTO)).thenReturn(Mono.just(playerDTO));

        webTestClient.post().uri("/player/create")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(playerDTO), PlayerDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PlayerDTO.class)
                .value(userResponse ->{
                    Assertions.assertThat(userResponse.getPlayerId()).isEqualTo(playerDTO.getPlayerId());
                });
    }
}

