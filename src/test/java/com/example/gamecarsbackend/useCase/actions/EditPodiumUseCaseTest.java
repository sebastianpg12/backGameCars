package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.domain.entitys.Podium.Podium;
import com.example.gamecarsbackend.dto.PodiumDTO;
import com.example.gamecarsbackend.repository.PodiumRepository;
import com.example.gamecarsbackend.useCase.actions.EditPodiumUseCase;
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
class EditPodiumUseCaseTest {
    @SpyBean
    EditPodiumUseCase editPodiumUseCase;

    @MockBean
    PodiumRepository podiumRepository;

    @Test
    void updatePodium(){
        PodiumDTO podiumDTO = new PodiumDTO("7","2" ,"2","2","2",false);
        Podium podium = new Podium();
        podium.setPodiumId("7");
        podium.setFirstPlace("2");
        podium.setFirstPlace("2");
        podium.setSecondPlace("2");
        podium.setThirdPlace("2");
        podium.setGameId("2");
        podium.setIsFull(false);

        when(podiumRepository.save(Mockito.any(Podium.class))).thenReturn(Mono.just(podium));

        Mono<PodiumDTO> response = editPodiumUseCase.apply(podiumDTO);

        Assertions.assertEquals(response.block(), podiumDTO);
    }
}