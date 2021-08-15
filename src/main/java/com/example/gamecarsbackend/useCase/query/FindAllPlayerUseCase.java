package com.example.gamecarsbackend.useCase.query;

import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.mapper.PlayerMapper;
import com.example.gamecarsbackend.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class FindAllPlayerUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public FindAllPlayerUseCase(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public Flux<PlayerDTO> findAll(){
        return playerRepository.findAll()
                .flatMap(
                        player -> Flux.just(playerMapper.mapperToPlayerDTO().apply(player))
                );
    }
}
