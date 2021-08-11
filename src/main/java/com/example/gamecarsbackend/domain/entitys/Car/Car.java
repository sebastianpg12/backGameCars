package com.example.gamecarsbackend.domain.entitys.Car;

import com.example.gamecarsbackend.domain.entitys.Conductor.Conductor;
import com.example.gamecarsbackend.domain.values.Distance;
import com.example.gamecarsbackend.domain.entitys.Car.values.IdCar;
import com.example.gamecarsbackend.domain.values.IdGame;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "cars")
public class Car {

    protected IdCar idCar;
    protected Conductor conductor;
    protected Distance distance;
    protected IdGame idGame;
    private final Map<IdCar, Conductor> carros = new HashMap<>();



}
