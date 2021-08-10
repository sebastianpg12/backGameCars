package com.example.gamecarsbackend.domain.entitys.Lane.values;

import co.com.sofka.domain.generic.Identity;
import com.example.gamecarsbackend.domain.values.IdGame;

public class IdLane extends Identity {
    private IdLane(String id){
        super(id);
    }

    public static IdLane of (String id){
        return new IdLane(id);
    }
}
