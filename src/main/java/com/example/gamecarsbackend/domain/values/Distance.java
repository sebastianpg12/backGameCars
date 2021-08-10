package com.example.gamecarsbackend.domain.values;

import co.com.sofka.domain.generic.ValueObject;

public class Distance implements ValueObject<Integer> {
    private final Integer value;

    public Distance(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value(){
        return value;
    }
}
