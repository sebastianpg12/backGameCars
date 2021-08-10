package com.example.gamecarsbackend.domain.entitys.Game;

import com.example.gamecarsbackend.domain.entitys.Game.values.Points;
import com.example.gamecarsbackend.domain.values.Name;

public final class PlayerBuilder {
    protected Name name;
    protected Points points;

    private PlayerBuilder() {
    }

    public static PlayerBuilder aPlayer() {
        return new PlayerBuilder();
    }

    public PlayerBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder withPoints(Points points) {
        this.points = points;
        return this;
    }

    public Player build() {
        return new Player(null, name, points);
    }
}
