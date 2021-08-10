package com.example.gamecarsbackend.domain.entitys.Lane.values;

import co.com.sofka.domain.generic.ValueObject;

public class Meters implements ValueObject<Integer> {
    private final Integer value;

    public Meters(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value(){
        return value;
    }
}
