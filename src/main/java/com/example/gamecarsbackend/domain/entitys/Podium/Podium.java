package com.example.gamecarsbackend.domain.entitys.Podium;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Podium")
public class Podium {
    @Id
    private String podiumId;
    private String firstPlace;
    private String secondPlace;
    private String thirdPlace;
    private String gameId;
}
