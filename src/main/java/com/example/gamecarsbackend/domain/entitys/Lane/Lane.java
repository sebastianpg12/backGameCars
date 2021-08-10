package com.example.gamecarsbackend.domain.entitys.Lane;

import co.com.sofka.domain.generic.Entity;
import com.example.gamecarsbackend.domain.entitys.Car.values.IdCar;
import com.example.gamecarsbackend.domain.entitys.Lane.values.IdLane;
import com.example.gamecarsbackend.domain.entitys.Lane.values.Meters;
import com.example.gamecarsbackend.domain.values.IdGame;
import com.example.gamecarsbackend.domain.values.IdPlayer;
import com.example.gamecarsbackend.domain.values.Position;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Lane extends Entity<IdLane> {

    protected IdCar carroId;
    protected IdGame juegoId;
    protected Position position;
    protected Meters meters;
    protected Boolean finalDisplacement;

    public Lane(IdLane entityId, IdCar carroId, IdGame juegoId, Position position, Meters meters, Boolean finalDisplacement) {
        super(entityId);
        this.carroId = carroId;
        this.juegoId = juegoId;
        this.position = position;
        this.meters = meters;
        this.finalDisplacement = finalDisplacement;
    }
}
