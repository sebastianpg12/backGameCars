package com.example.gamecarsbackend.domain.entitys.Conductor;

import com.example.gamecarsbackend.domain.values.Name;

public final class ConductorBuilder {
    protected com.example.gamecarsbackend.domain.values.Name Name;

    private ConductorBuilder() {
    }

    public static ConductorBuilder aConductor() {
        return new ConductorBuilder();
    }

    public ConductorBuilder withName(Name Name) {
        this.Name = Name;
        return this;
    }

    public Conductor build() {
        Conductor conductor = new Conductor(null, null);
        conductor.setName(Name);
        return conductor;
    }
}
