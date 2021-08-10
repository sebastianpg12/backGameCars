package com.example.gamecarsbackend.domain.entitys.Car;

import com.example.gamecarsbackend.domain.entitys.Conductor.Conductor;
import com.example.gamecarsbackend.domain.values.Distance;
import com.example.gamecarsbackend.domain.values.IdGame;

public final class CarBuilder {
    protected Conductor conductor;
    protected Distance distance;
    protected IdGame idGame;

    private CarBuilder() {
    }

    public static CarBuilder aCar() {
        return new CarBuilder();
    }

    public CarBuilder withConductor(Conductor conductor) {
        this.conductor = conductor;
        return this;
    }

    public CarBuilder withDistance(Distance distance) {
        this.distance = distance;
        return this;
    }

    public CarBuilder withIdGame(IdGame idGame) {
        this.idGame = idGame;
        return this;
    }

    public Car build() {
        return new Car(null, conductor, distance, idGame);
    }
}
