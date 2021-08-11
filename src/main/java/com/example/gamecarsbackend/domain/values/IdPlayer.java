package com.example.gamecarsbackend.domain.values;


import java.util.UUID;

public class IdPlayer {
    private UUID id;

    public IdPlayer(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}
