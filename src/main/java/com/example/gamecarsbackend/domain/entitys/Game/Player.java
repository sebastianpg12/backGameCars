package com.example.gamecarsbackend.domain.entitys.Game;

import com.example.gamecarsbackend.domain.entitys.Car.values.IdCar;
import com.example.gamecarsbackend.domain.values.AmountPositionsObtained;
import com.example.gamecarsbackend.domain.values.IdPlayer;
import com.example.gamecarsbackend.domain.values.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Document(collection = "Player")
public class Player {
    @Id
    private final IdPlayer idPlayer;
    private final Name name;
    private final AmountPositionsObtained firstPosition;
    private final AmountPositionsObtained secondPosition;
    private final AmountPositionsObtained thirdPosition;
    private final IdCar idCar;
}
