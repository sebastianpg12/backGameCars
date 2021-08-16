package com.example.gamecarsbackend.useCase.actions;


import com.example.gamecarsbackend.dto.GameDTO;
import com.example.gamecarsbackend.mapper.GameMapper;
import com.example.gamecarsbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;


@Service
@Validated
public class CreateGameUseCase {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    @Autowired
    public CreateGameUseCase(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }
    public Mono<GameDTO> createGame(GameDTO gameDTO){
        return gameRepository.save(gameMapper.mapperToGame(gameDTO.getGameId())
                .apply(gameDTO))
                    .map(gameMapper.mapperToGameDTO());
    }
}
