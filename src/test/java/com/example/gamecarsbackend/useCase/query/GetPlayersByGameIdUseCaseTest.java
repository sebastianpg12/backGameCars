package com.example.gamecarsbackend.useCase.query;

import com.example.gamecarsbackend.domain.entitys.Car.Car;
import com.example.gamecarsbackend.domain.entitys.Game.Player;
import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.repository.CarRepository;
import com.example.gamecarsbackend.repository.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetPlayersByGameIdUseCaseTest {

    @SpyBean
    GetPlayersByGameIdUseCase getPlayersByGameIdUseCase;

    @MockBean
    PlayerRepository playerRepository;

    @Test
    void finPlayerdByIdGame() {
        PlayerDTO playerDTO = new PlayerDTO("7", "Carlos", 0, 0, 0, "5", "7");
        Player player = new Player("7", "Carlos", 0, 0, 0, "5", "7");

        when(playerRepository.findByGameId(Mockito.any(String.class))).thenReturn(Flux.just(player));

        Flux<PlayerDTO> response = getPlayersByGameIdUseCase.getPlayersByGameId(playerDTO.getGameId());

        Assertions.assertEquals(response.blockFirst().getGameId(), "5");
    }

}