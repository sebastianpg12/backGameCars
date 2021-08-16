package com.example.gamecarsbackend.domain.entitys.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Car")
public class Car {
    @Id
    private String carId;
    private Boolean goal;
    private Integer currentPosition;
    private Integer advance;
    private String driverId;
    private String gameId;
    private String laneId;
    private String namePlayer;

}
