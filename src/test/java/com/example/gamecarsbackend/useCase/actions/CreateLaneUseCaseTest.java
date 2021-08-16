package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.domain.entitys.Lane.Lane;
import com.example.gamecarsbackend.dto.LaneDTO;
import com.example.gamecarsbackend.repository.LaneRepository;
import com.example.gamecarsbackend.useCase.actions.CreateLaneUseCase;
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
class CreateLaneUseCaseTest {

    @SpyBean
    CreateLaneUseCase createLaneUseCase;

    @MockBean
    LaneRepository laneRepository;

    @Test
    void createLane(){
        LaneDTO laneDTO = new LaneDTO("8", "5", "9", "2", "1");
        Lane lane = new Lane();
        lane.setLaneId("8");
        lane.setCarId("5");
        lane.setGameId("9");
        lane.setTrackId("2");
        lane.setDriverId("1");

        when(laneRepository.save(Mockito.any(Lane.class))).thenReturn(Mono.just(lane));

        Mono<LaneDTO> response = createLaneUseCase.createLane(laneDTO);

        Assertions.assertEquals(response.block(), laneDTO);

    }
}