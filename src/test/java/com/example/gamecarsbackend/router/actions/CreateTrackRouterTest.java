package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.dto.TrackDTO;
import com.example.gamecarsbackend.router.query.FindAllPlayerRouter;
import com.example.gamecarsbackend.useCase.actions.CreateCarUseCase;
import com.example.gamecarsbackend.useCase.actions.CreateTrackUseCase;
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
@ContextConfiguration(classes = {CreateTrackRouter.class})

class CreateTrackRouterTest {
    @MockBean
    private CreateTrackUseCase createTrackUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createTrack(){
        TrackDTO trackDTO = new TrackDTO("9",200 ,"4","5");

        when(createTrackUseCase.apply(trackDTO)).thenReturn(Mono.just(trackDTO));

        webTestClient.post().uri("/create/track")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(trackDTO), TrackDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(TrackDTO.class)
                .value(userResponse ->{
                    Assertions.assertThat(userResponse.getTrackId()).isEqualTo(trackDTO.getTrackId());
                });
    }
}