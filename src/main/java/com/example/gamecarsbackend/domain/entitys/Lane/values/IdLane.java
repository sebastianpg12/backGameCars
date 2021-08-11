package com.example.gamecarsbackend.domain.entitys.Lane.values;


import java.util.UUID;

public class IdLane {
    private final UUID id;

    public IdLane(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}
