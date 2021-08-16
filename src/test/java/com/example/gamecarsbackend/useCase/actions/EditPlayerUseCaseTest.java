package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.domain.entitys.Game.Player;
import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.repository.PlayerRepository;
import com.example.gamecarsbackend.useCase.actions.EditPlayerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;


import static org.mockito.Mockito.when;

@SpringBootTest
class EditPlayerUseCaseTest {
    @SpyBean
    EditPlayerUseCase editPlayerUseCase;

    @MockBean
    PlayerRepository playerRepository;

    @Test
    void updatePlayer(){
        PlayerDTO playerDTO = new PlayerDTO("7", "Carlos", 0, 0, 0, "5", "7");
        Player player = new Player();
        player.setPlayerId("7");
        player.setName("Carlos");
        player.setFirstPlace(0);
        player.setSecondPlace(0);
        player.setThirdPlace(0);
        player.setGameId("5");
        player.setDriverId("7");

        when(playerRepository.save(Mockito.any(Player.class))).thenReturn(Mono.just(player));

        Mono<PlayerDTO> response = editPlayerUseCase.modifyPlayer(playerDTO);

        Assertions.assertEquals(response.block(), playerDTO);
    }
}