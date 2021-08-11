package com.example.gamecarsbackend.domain.entitys.Lane;

import com.example.gamecarsbackend.domain.entitys.Car.values.IdCar;
import com.example.gamecarsbackend.domain.entitys.Lane.values.IdLane;
import com.example.gamecarsbackend.domain.entitys.Lane.values.Meters;
import com.example.gamecarsbackend.domain.values.IdGame;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Lane {

    private final IdLane idLane;
    private final IdCar carroId;
    private final IdGame juegoId;
    private final Meters meters;
    private final Boolean finalDisplacement;

    public Lane(IdLane idLane, IdCar carroId, IdGame juegoId, Meters meters, Boolean finalDisplacement) {
        this.idLane = idLane;
        this.carroId = carroId;
        this.juegoId = juegoId;
        this.meters = meters;
        this.finalDisplacement = finalDisplacement;
    }
}
