package com.example.gamecarsbackend.useCase;

import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.mapper.PlayerMapper;
import com.example.gamecarsbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreatePlayerUseCase  {

    private final PlayerRepository playerDTORepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public CreatePlayerUseCase(PlayerRepository playerDTORepository, PlayerMapper playerMapper) {
        this.playerDTORepository = playerDTORepository;
        this.playerMapper = playerMapper;
    }

    public Mono<PlayerDTO> apply(PlayerDTO playerDTO) {
        return playerDTORepository
                .save(playerMapper.mapperToPlayer(playerDTO.getPlayerId())
                        .apply(playerDTO))
                .thenReturn(playerDTO);
    }
}