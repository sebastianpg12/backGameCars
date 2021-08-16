package com.example.gamecarsbackend.useCase.query;

import com.example.gamecarsbackend.domain.entitys.Game.Player;
import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.repository.PlayerRepository;
import com.example.gamecarsbackend.useCase.query.FindByIdPlayerUseCase;
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
class FindByIdPlayerUseCaseTest {
    @SpyBean
    FindByIdPlayerUseCase findByIdPlayerUseCase;

    @MockBean
    PlayerRepository playerRepository;

    @Test
    void findByIdPlayer() {
        PlayerDTO playerDTO = new PlayerDTO("7","Carlos",0,0,0,"5","7");
        Player player = new Player();
        player.setPlayerId("7");
        player.setName("Carlos");
        player.setFirstPlace(0);
        player.setSecondPlace(0);
        player.setThirdPlace(0);
        player.setGameId("5");
        player.setDriverId("10");

        when(playerRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(player));

        Mono<PlayerDTO> response = findByIdPlayerUseCase.findById(playerDTO.getPlayerId());

        Assertions.assertEquals(response.block().getPlayerId(), "7");
    }
}