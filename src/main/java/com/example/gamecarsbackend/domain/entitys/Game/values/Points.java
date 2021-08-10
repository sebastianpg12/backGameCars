package com.example.gamecarsbackend.domain.entitys.Game.values;

import co.com.sofka.domain.generic.ValueObject;

public class Points implements ValueObject<Integer> {
    private final Integer value;

    public Points(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value(){
        return value;
    }
}
