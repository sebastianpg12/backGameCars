package com.example.gamecarsbackend.domain.values;


import java.util.UUID;

public class IdGame {
    private final UUID id;

    public IdGame(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}
