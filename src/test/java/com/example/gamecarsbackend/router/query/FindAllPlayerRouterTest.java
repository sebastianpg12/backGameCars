package com.example.gamecarsbackend.router.query;

import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.useCase.actions.CreateTrackUseCase;
import com.example.gamecarsbackend.useCase.query.FindAllPlayerUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FindAllPlayerRouter.class})

class FindAllPlayerRouterTest {

        @MockBean
        private FindAllPlayerUseCase findAllPlayerUseCase;

        @Autowired
        private WebTestClient webTestClient;

        @Test
        void findAllPlayer(){
                PlayerDTO playerDTO = new PlayerDTO("7", "Carlos", 0, 0, 0, "5", "7");

                when(findAllPlayerUseCase.findAll()).thenReturn(Flux.just(playerDTO));

                webTestClient.get()
                        .uri("/get/players").accept(APPLICATION_JSON)
                        .exchange()
                        .expectStatus().isOk()
                        .expectHeader().contentType(APPLICATION_JSON)
                        .expectBodyList(PlayerDTO.class);
        }


        }

