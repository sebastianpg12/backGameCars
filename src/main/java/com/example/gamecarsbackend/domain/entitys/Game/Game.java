package com.example.gamecarsbackend.domain.entitys.Game;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Game {
    @Id
    private String gameId;
    private String trackId;


}
