package com.example.gamecarsbackend.useCase.actions;


import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.mapper.PlayerMapper;
import com.example.gamecarsbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreatePlayerUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public CreatePlayerUseCase(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public Mono<PlayerDTO> apply(PlayerDTO playerDTO) {
        return playerRepository
                .save(playerMapper.mapperToPlayer(playerDTO.getPlayerId())
                        .apply(playerDTO))
                .map(playerMapper.mapperToPlayerDTO());
    }
}
