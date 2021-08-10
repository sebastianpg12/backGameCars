package com.example.gamecarsbackend.domain.entitys.Conductor;

import co.com.sofka.domain.generic.Entity;
import com.example.gamecarsbackend.domain.entitys.Conductor.values.IdConductor;
import com.example.gamecarsbackend.domain.values.*;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "cars")
public class Conductor extends Entity<IdConductor> {
    protected Name Name;

    public Conductor(IdConductor entityId, Name name) {
        super(entityId);
        Name = name;
    }

    public Integer throwDice() {
        int randomDice = (int) (Math.random() * 6 + 1);
        return randomDice;
    }

    public com.example.gamecarsbackend.domain.values.Name getName() {
        return Name;
    }

    public void setName(com.example.gamecarsbackend.domain.values.Name name) {
        Name = name;
    }
}
