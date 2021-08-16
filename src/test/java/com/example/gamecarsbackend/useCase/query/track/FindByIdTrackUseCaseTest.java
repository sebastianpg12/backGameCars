package com.example.gamecarsbackend.useCase.query.track;

import com.example.gamecarsbackend.domain.entitys.Track.Track;
import com.example.gamecarsbackend.dto.TrackDTO;
import com.example.gamecarsbackend.repository.TrackRepository;
import com.example.gamecarsbackend.useCase.query.FindByIdTrackUseCase;
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
class FindByIdTrackUseCaseTest {

    @SpyBean
    FindByIdTrackUseCase findByIdTrackUseCase;

    @MockBean
    TrackRepository trackRepository;

    @Test
    void createTrack(){
        var trackDTO = new TrackDTO("9",200 ,"4","5");
        var track = new Track();
        track.setTrackId("9");
        track.setTrackDistance(200);
        track.setGameId("4");
        track.setPodiumId("5");

        when(trackRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(track));

        var response = findByIdTrackUseCase.getfindbyid(trackDTO.getTrackId());

        Assertions.assertEquals(response.block().getTrackId(), "9");
    }
}