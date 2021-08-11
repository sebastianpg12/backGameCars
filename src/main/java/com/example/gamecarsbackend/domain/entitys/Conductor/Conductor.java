package com.example.gamecarsbackend.domain.entitys.Conductor;


import com.example.gamecarsbackend.domain.entitys.Conductor.values.IdConductor;
import com.example.gamecarsbackend.domain.values.*;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "cars")
public class Conductor  {
    protected IdConductor idConductor;
    protected Name Name;



}
