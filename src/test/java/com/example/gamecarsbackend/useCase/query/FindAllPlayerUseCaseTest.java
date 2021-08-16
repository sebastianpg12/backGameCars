package com.example.gamecarsbackend.useCase.query;

import com.example.gamecarsbackend.domain.entitys.Game.Game;
import com.example.gamecarsbackend.domain.entitys.Game.Player;
import com.example.gamecarsbackend.dto.GameDTO;
import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.repository.GameRepository;
import com.example.gamecarsbackend.repository.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FindAllPlayerUseCaseTest {
    @SpyBean
    FindAllPlayerUseCase findAllPlayerUseCase;

    @MockBean
    PlayerRepository playerRepository;

    @Test
    void findByIdAllPlayer() {
        PlayerDTO playerDTO = new PlayerDTO("7","Carlos",0,0,0,"5","7");
        Player player = new Player("7","Carlos",0,0,0,"5","7");

        when(playerRepository.findAll()).thenReturn(Flux.just(player));


        Flux<PlayerDTO> response = findAllPlayerUseCase.findAll();

        Assertions.assertEquals(response.blockFirst(), playerDTO);
    }

}