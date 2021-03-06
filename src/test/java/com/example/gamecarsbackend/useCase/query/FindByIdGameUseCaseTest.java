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
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FindByIdGameUseCaseTest {
    @SpyBean
    FindByIdGameUseCase findByIdGameUseCase;

    @MockBean
    GameRepository gameRepository;

    @Test
    void findByIdGame() {
        GameDTO gameDTO = new GameDTO("45","84", false);
        Game game = new  Game("45","84", false);

        when(gameRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(game));

        Mono<GameDTO> response = findByIdGameUseCase.findById(gameDTO.getGameId());

        Assertions.assertEquals(response.block().getGameId(), "45");
    }

}