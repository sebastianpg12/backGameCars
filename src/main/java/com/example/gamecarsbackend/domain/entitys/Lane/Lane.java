package com.example.gamecarsbackend.domain.entitys.Lane;

import com.example.gamecarsbackend.domain.entitys.Car.values.IdCar;
import com.example.gamecarsbackend.domain.entitys.Lane.values.IdLane;
import com.example.gamecarsbackend.domain.entitys.Lane.values.Meters;
import com.example.gamecarsbackend.domain.values.IdGame;
import com.example.gamecarsbackend.domain.values.Position;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Lane {

    protected IdLane idLane;
    protected IdCar carroId;
    protected IdGame juegoId;
    protected Position position;
    protected Meters meters;
    protected Boolean finalDisplacement;


}
