package com.example.gamecarsbackend.mapper;

import com.example.gamecarsbackend.domain.entitys.Game.Game;
import com.example.gamecarsbackend.dto.GameDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class GameMapper {
    public Function<GameDTO, Game> mapperToGame(String id){
        return updateGame -> {
            Game game = new Game();
            game.setGameId(id);
            game.setTrackId(updateGame.getTrackId());
            game.setIsFinished(updateGame.getIsFinished());
            return  game;
        };
    }

    public Function<Game,GameDTO> mapperToGameDTO(){
        return game -> new GameDTO(
                game.getGameId(),
                game.getTrackId(),
                game.getIsFinished()

        );
    }
}