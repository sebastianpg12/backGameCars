package com.example.gamecarsbackend.domain.entitys.Car;

import co.com.sofka.domain.generic.Entity;
import com.example.gamecarsbackend.domain.entitys.Conductor.Conductor;
import com.example.gamecarsbackend.domain.values.Distance;
import com.example.gamecarsbackend.domain.entitys.Car.values.IdCar;
import com.example.gamecarsbackend.domain.values.IdGame;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "cars")
public class Car extends Entity<IdCar> {

    protected Conductor conductor;
    protected Distance distance;
    protected IdGame idGame;
    private final Map<IdCar, Conductor> carros = new HashMap<>();

    public Car(IdCar entityId, Conductor conductor, Distance distance, IdGame idGame) {
        super(entityId);
        this.conductor = conductor;
        this.distance = distance;
        this.idGame = idGame;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public IdGame getIdGame() {
        return idGame;
    }

    public void setIdGame(IdGame idGame) {
        this.idGame = idGame;
    }

    public Map<IdCar, Conductor> getCarros() {
        return carros;
    }
}
