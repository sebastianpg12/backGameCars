package com.example.gamecarsbackend.domain.entitys.Game;

import co.com.sofka.domain.generic.Entity;
import com.example.gamecarsbackend.domain.entitys.Game.values.Points;
import com.example.gamecarsbackend.domain.values.IdPlayer;
import com.example.gamecarsbackend.domain.values.Name;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;

@Document(collection = "cars")
public class Player extends Entity<IdPlayer> {

    protected Name name;
    protected Points points;

    public Player(IdPlayer entityId, Name name, Points points) {
        super(entityId);
        this.name = name;
        this.points = points;
    }

    public Name getName() {
        return name;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
       points = points;
    }
}
