package com.example.gamecarsbackend.domain.entitys.Car.values;


import java.util.UUID;

public class IdCar{
    private UUID id;

    public IdCar(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}


