package com.example.gamecarsbackend.useCase.query;


import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.mapper.PlayerMapper;
import com.example.gamecarsbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetPlayersByGameIdUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public GetPlayersByGameIdUseCase(PlayerRepository playerDTORepository, PlayerMapper playerMapper) {
        this.playerRepository = playerDTORepository;
        this.playerMapper = playerMapper;
    }

    public Flux<PlayerDTO> getPlayersByGameId(String id){
        return playerRepository.findByGameId(id)
                .flatMap(
                        player -> Flux.just(playerMapper.mapperToPlayerDTO().apply(player))
                );
    }
}
