package com.example.gamecarsbackend.domain.entitys.Game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Game")
public class Game {
    @Id
    private String gameId;
    private String trackId;




}
