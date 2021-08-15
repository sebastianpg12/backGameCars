package com.example.gamecarsbackend.mapper;

import com.example.gamecarsbackend.domain.entitys.Car.values.IdCar;
import com.example.gamecarsbackend.domain.entitys.Game.Player;
import com.example.gamecarsbackend.domain.values.AmountPositionsObtained;
import com.example.gamecarsbackend.domain.values.IdPlayer;
import com.example.gamecarsbackend.domain.values.Name;
import com.example.gamecarsbackend.dto.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;



@Component
public class PlayerMapper {

    public Function<PlayerDTO, Player> mapperToPlayer(String id){
        return updatePlayer -> {
            Player player = new Player();
            player.setPlayerId(id);
            player.setName(updatePlayer.getName());
            player.setFirstPlace(updatePlayer.getFirstPlace());
            player.setSecondPlace(updatePlayer.getSecondPlace());
            player.setThirdPlace(updatePlayer.getThirdPlace());
            player.setGameId(updatePlayer.getGameId());
            player.setDriverId(updatePlayer.getDriverId());
            return player;
        };
    }

    public Function<Player,PlayerDTO> mapperToPlayerDTO(){
        return player -> new PlayerDTO(
                player.getPlayerId(),
                player.getName(),
                player.getFirstPlace(),
                player.getSecondPlace(),
                player.getThirdPlace(),
                player.getGameId(),
                player.getDriverId()
        );
    }
}