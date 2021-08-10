package com.example.gamecarsbackend.domain.entitys.Car.values;

import co.com.sofka.domain.generic.Identity;

public class IdCar extends Identity {
    private IdCar(String id){
        super(id);
    }

    public static IdCar of (String id){
        return new IdCar(id);
    }
}


