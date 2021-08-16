package com.example.gamecarsbackend.useCase.query.podium;

import com.example.gamecarsbackend.domain.entitys.Podium.Podium;
import com.example.gamecarsbackend.dto.PodiumDTO;
import com.example.gamecarsbackend.repository.PodiumRepository;
import com.example.gamecarsbackend.useCase.query.FindByIdPodiumUseCase;
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
class FindByIdPodiumUseCaseTest {
    @SpyBean
    FindByIdPodiumUseCase findByIdPodiumUseCase;

    @MockBean
    PodiumRepository podiumRepository;
    @Test
    void updatePodium(){
        var podiumDTO = new PodiumDTO("7","1" ,"1","1","1",false);
        var podium = new Podium();
        podium.setPodiumId("7");
        podium.setFirstPlace("1");
        podium.setSecondPlace("1");
        podium.setThirdPlace("1");
        podium.setGameId("1");
        podium.setIsFull(false);

        when(podiumRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(podium));

        var response = findByIdPodiumUseCase.getfindbyid(podiumDTO.getPodiumId());

        Assertions.assertEquals(response.block().getPodiumId(), "7");
    }

}