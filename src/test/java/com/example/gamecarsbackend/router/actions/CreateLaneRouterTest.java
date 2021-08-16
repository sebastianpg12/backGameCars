package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.dto.LaneDTO;
import com.example.gamecarsbackend.router.query.FindAllPlayerRouter;
import com.example.gamecarsbackend.useCase.actions.CreateCarUseCase;
import com.example.gamecarsbackend.useCase.actions.CreateLaneUseCase;
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
@ContextConfiguration(classes = {CreateLaneRouter.class})

class CreateLaneRouterTest {
    @MockBean
    private CreateLaneUseCase createLaneUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createLane(){
        LaneDTO laneDTO = new LaneDTO("8", "5", "9", "2", "1");

        when(createLaneUseCase.createLane(laneDTO)).thenReturn(Mono.just(laneDTO));

        webTestClient.post().uri("/lane/create")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(laneDTO), LaneDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(LaneDTO.class)
                .value(userResponse ->{
                    Assertions.assertThat(userResponse.getLaneId()).isEqualTo(laneDTO.getLaneId());
                });
    }
}