package com.example.gamecarsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Player")
public class PlayerDTO {

    @Id
    private String playerId;
    private String name;
    private Integer firstPlace;
    private Integer secondPlace;
    private Integer thirdPlace;
    private String carId;
}