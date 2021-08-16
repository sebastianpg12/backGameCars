package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.DriverDTO;
import com.example.gamecarsbackend.dto.GameDTO;
import com.example.gamecarsbackend.router.query.FindAllPlayerRouter;
import com.example.gamecarsbackend.useCase.actions.CreateCarUseCase;
import com.example.gamecarsbackend.useCase.actions.CreateGameUseCase;
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
@ContextConfiguration(classes = {CreateGameUseCase.class})

class CreateGameRouterTest {

    @MockBean
    private CreateGameUseCase createGameUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createGame(){
        GameDTO gameDTO = new GameDTO("45","84", false);

        webTestClient.post().uri("/create/game")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(gameDTO), GameDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(GameDTO.class)
                .value(userResponse ->{
                    Assertions.assertThat(userResponse.getGameId()).isEqualTo(gameDTO.getGameId());
                });
    }
    }

