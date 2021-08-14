package com.example.gamecarsbackend.domain.entitys.Driver;

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
@Document(collection = "Driver")
public class Driver {

    @Id
    private  String driverId;
    private  Integer position;
    private  String playerId;
    private  String railId;
    private  String carId;

}
