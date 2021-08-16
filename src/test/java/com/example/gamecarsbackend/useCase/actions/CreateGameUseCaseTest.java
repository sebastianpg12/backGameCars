package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.domain.entitys.Game.Game;
import com.example.gamecarsbackend.dto.GameDTO;
import com.example.gamecarsbackend.repository.GameRepository;
import com.example.gamecarsbackend.useCase.actions.CreateGameUseCase;
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
class CreateGameUseCaseTest {

    @SpyBean
    CreateGameUseCase createGameUseCase;

    @MockBean
    GameRepository gameRepository;

    @Test
    void crearGame(){
        GameDTO gameDTO = new GameDTO("45","84", false);
        Game game = new Game();
        game.setGameId("45");
        game.setTrackId("84");
        game.setIsFinished(false);

        when(gameRepository.save(Mockito.any(Game.class))).thenReturn(Mono.just(game));

        Mono<GameDTO> response = createGameUseCase.createGame(gameDTO);

        Assertions.assertEquals(response.block(), gameDTO);
    }
}