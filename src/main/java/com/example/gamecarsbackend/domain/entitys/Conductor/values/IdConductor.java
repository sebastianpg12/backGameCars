package com.example.gamecarsbackend.domain.entitys.Conductor.values;


import java.util.UUID;

public class IdConductor {

    private UUID id;

    public IdConductor(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}
