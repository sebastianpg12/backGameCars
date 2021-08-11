package com.example.gamecarsbackend.domain.values;



public class Position implements Props {

    private Integer actual;
    private Integer meta;

    @Override
    public Integer actual() {
        return actual;
    }

    @Override
    public Integer meta() {
        return meta;
    }

    public void setActual(Integer actual) {
        this.actual = actual;
    }

    public Position(Integer actual, Integer meta) {
        this.actual = actual;
        this.meta = meta;
    }

}

interface Props {

    public Integer actual();

    public Integer meta();

}