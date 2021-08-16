package com.example.gamecarsbackend.dto;

import com.example.gamecarsbackend.mapper.PodiumMapper;
import com.example.gamecarsbackend.repository.PodiumRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Car")
public class CarDTO {

    @Id
    private String carId;
    private Boolean goal;
    private Integer currentPosition;
    private Integer advance;
    private String driverId;
    private String gameId;
    private String laneId;
    private String namePlayer;


    public void advanceCar(String trackDistance) {
        int distance = Integer.parseInt(trackDistance) * 1000;
        if (this.getAdvance() < distance) {
            this.setAdvance((int) (this.getAdvance() + (Math.random() * 6 + 1) * 100));
            updateCurrentPosition(distance);
        } else { setGoal(true); }
    }

    private void updateCurrentPosition(int distance) {
        this.setCurrentPosition(90-((this.getAdvance() * 90) / distance));
        if(getCurrentPosition() < 0 ){
            setCurrentPosition(0);
        }
    }
}
