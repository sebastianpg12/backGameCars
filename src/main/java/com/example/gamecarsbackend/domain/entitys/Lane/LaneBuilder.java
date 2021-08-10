package com.example.gamecarsbackend.domain.entitys.Lane;

import com.example.gamecarsbackend.domain.entitys.Car.values.IdCar;
import com.example.gamecarsbackend.domain.entitys.Lane.values.Meters;
import com.example.gamecarsbackend.domain.values.IdGame;
import com.example.gamecarsbackend.domain.values.Position;

public final class LaneBuilder {
    protected IdCar carroId;
    protected IdGame juegoId;
    protected Position position;
    protected Meters meters;
    protected Boolean finalDisplacement;

    private LaneBuilder() {
    }

    public static LaneBuilder aLane() {
        return new LaneBuilder();
    }

    public LaneBuilder withCarroId(IdCar carroId) {
        this.carroId = carroId;
        return this;
    }

    public LaneBuilder withJuegoId(IdGame juegoId) {
        this.juegoId = juegoId;
        return this;
    }

    public LaneBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public LaneBuilder withMeters(Meters meters) {
        this.meters = meters;
        return this;
    }

    public LaneBuilder withFinalDisplacement(Boolean finalDisplacement) {
        this.finalDisplacement = finalDisplacement;
        return this;
    }

    public Lane build() {
        return new Lane(null, carroId, juegoId, position, meters, finalDisplacement);
    }
}
