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
        return updatePlayer -> new Player(
                IdPlayer.of(id),
                new Name(updatePlayer.getName()),
                new AmountPositionsObtained(updatePlayer.getFirstPlace()),
                new AmountPositionsObtained(updatePlayer.getSecondPlace()),
                new AmountPositionsObtained(updatePlayer.getThirdPlace()),
                IdCar.of(updatePlayer.getCarId())
        );
    }

    public Function<Player,PlayerDTO> mapperToPlayerDTO(){
        return player -> new PlayerDTO(
                player.getIdPlayer().getId(),
                player.getName().getName(),
                player.getFirstPosition().getAmountPositionsObtained(),
                player.getSecondPosition().getAmountPositionsObtained(),
                player.getThirdPosition().getAmountPositionsObtained(),
                player.getIdCar().getId()
        );
    }
}
