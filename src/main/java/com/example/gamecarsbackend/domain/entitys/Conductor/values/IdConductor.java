package com.example.gamecarsbackend.domain.entitys.Conductor.values;

import co.com.sofka.domain.generic.Identity;

public class IdConductor extends Identity {
    private IdConductor(String id){
        super(id);
    }

    public static IdConductor of (String id){
        return new IdConductor(id);
    }
}
