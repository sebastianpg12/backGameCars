package com.example.gamecarsbackend.useCase.actions;

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
class EditGameUseCaseTest {
    @SpyBean
    EditGameUseCase editGameUseCase;

    @MockBean
    GameRepository gameRepository;

    @Test
    void updateGame(){
        GameDTO gameDTO = new GameDTO("45","84", false);
        Game game = new  Game("45","84", false);

        when(gameRepository.save(Mockito.any(Game.class))).thenReturn(Mono.just(game));

        Mono<GameDTO> response = editGameUseCase.modifyGame(gameDTO);

        Assertions.assertEquals(response.block(), gameDTO);
    }

}