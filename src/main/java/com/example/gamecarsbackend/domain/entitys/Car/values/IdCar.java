package com.example.gamecarsbackend.domain.entitys.Car.values;


import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class IdCar{
    private final String id;

    public static IdCar of (String id){return new IdCar(id);}


    public String getId() {
        return id.toString();
    }
}


