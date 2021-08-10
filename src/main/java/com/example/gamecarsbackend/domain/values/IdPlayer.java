package com.example.gamecarsbackend.domain.values;

import co.com.sofka.domain.generic.Identity;

public class IdPlayer extends Identity {
    private IdPlayer(String id){
        super(id);
    }

    public static IdPlayer of (String id){
        return new IdPlayer(id);
    }
}
