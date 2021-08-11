package com.example.gamecarsbackend.domain.entitys.Game;

import com.example.gamecarsbackend.domain.entitys.Game.values.Points;
import com.example.gamecarsbackend.domain.values.IdPlayer;
import com.example.gamecarsbackend.domain.values.Name;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;

@Document(collection = "cars")
public class Player {
    protected IdPlayer idPlayer;
    protected Name name;
    protected Points points;

}
