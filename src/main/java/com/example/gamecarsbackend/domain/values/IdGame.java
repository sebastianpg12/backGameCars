package com.example.gamecarsbackend.domain.values;

import co.com.sofka.domain.generic.Identity;

public class IdGame extends Identity {
    private IdGame(String id){
        super(id);
    }

    public static IdGame of (String id){
        return new IdGame(id);
    }
}
