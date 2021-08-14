package com.example.gamecarsbackend.domain.entitys.Lane;

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
@Document(collection = "Lane")
public class Lane {
    @Id
    private String railId;
    private String carId;
    private String gameId;
    private String trackId;
    private String driverId;
}

