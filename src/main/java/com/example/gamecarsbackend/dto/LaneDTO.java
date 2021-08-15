package com.example.gamecarsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Lane")
public class LaneDTO {

    @Id
    private String laneId;
    private String carId;
    private String gameId;
    private String trackId;
    private String driverId;
}
