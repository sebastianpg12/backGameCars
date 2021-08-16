package com.example.gamecarsbackend.useCase.actions.track;

import com.example.gamecarsbackend.domain.entitys.Track.Track;
import com.example.gamecarsbackend.dto.TrackDTO;
import com.example.gamecarsbackend.repository.TrackRepository;
import com.example.gamecarsbackend.useCase.actions.CreateTrackUseCase;
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
class CreateTrackUseCaseTest {
    @SpyBean
    CreateTrackUseCase createTrackUseCase;

    @MockBean
    TrackRepository trackRepository;

    @Test
    void createTrack(){
        TrackDTO trackDTO = new TrackDTO("9",200 ,"4","5");
        Track track = new Track();
        track.setTrackId("9");
        track.setTrackDistance(200);
        track.setGameId("4");
        track.setPodiumId("5");


        when(trackRepository.save(Mockito.any(Track.class))).thenReturn(Mono.just(track));

        Mono<TrackDTO> response = createTrackUseCase.apply(trackDTO);

        Assertions.assertEquals(response.block(), trackDTO);
    }

}