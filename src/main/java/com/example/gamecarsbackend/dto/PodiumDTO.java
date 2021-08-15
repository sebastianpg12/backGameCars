package com.example.gamecarsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Podium")
public class PodiumDTO {

    @Id
    private String podiumId;
    private String firstPlace;
    private String secondPlace;
    private String thirdPlace;
    private String gameId;
}
