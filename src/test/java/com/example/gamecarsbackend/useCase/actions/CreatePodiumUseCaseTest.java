package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.domain.entitys.Podium.Podium;
import com.example.gamecarsbackend.dto.PodiumDTO;
import com.example.gamecarsbackend.repository.PodiumRepository;
import com.example.gamecarsbackend.useCase.actions.CreatePodiumUseCase;
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
class CreatePodiumUseCaseTest {
    @SpyBean
    CreatePodiumUseCase createPodiumUseCase;

    @MockBean
    PodiumRepository podiumRepository;

    @Test
    void createPodium(){
        PodiumDTO podiumDTO = new PodiumDTO("7","Andres" ,"Carlos","Pablo","2",false);
        Podium podium = new Podium();
        podium.setPodiumId("7");
        podium.setGameId("2");
        podium.setFirstPlace("Andres");
        podium.setSecondPlace("Carlos");
        podium.setThirdPlace("Pablo");
        podium.setIsFull(false);

        when(podiumRepository.save(Mockito.any(Podium.class))).thenReturn(Mono.just(podium));

        Mono<PodiumDTO> response = createPodiumUseCase.apply(podiumDTO);

        Assertions.assertEquals(response.block(), podiumDTO);
    }
}