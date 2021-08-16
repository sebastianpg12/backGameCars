package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.dto.PodiumDTO;
import com.example.gamecarsbackend.router.query.FindAllPlayerRouter;
import com.example.gamecarsbackend.router.query.FindByIdPodiumRouter;
import com.example.gamecarsbackend.useCase.actions.CreateCarUseCase;
import com.example.gamecarsbackend.useCase.actions.CreatePodiumUseCase;
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
@ContextConfiguration(classes = {CreatePodiumRouter.class})

class CreatePodiumRouterTest {

    @MockBean
    private CreatePodiumUseCase createPodiumUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createPodium(){
        PodiumDTO podiumDTO = new PodiumDTO("7","Andres" ,"Carlos","Pablo","2",false);

        when(createPodiumUseCase.apply(podiumDTO)).thenReturn(Mono.just(podiumDTO));

        webTestClient.post().uri("/podium/create")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(podiumDTO), PodiumDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PodiumDTO.class)
                .value(userResponse ->{
                    Assertions.assertThat(userResponse.getPodiumId()).isEqualTo(podiumDTO.getPodiumId());
                });

    }
}