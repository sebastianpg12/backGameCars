package com.example.gamecarsbackend.mapper;
import com.example.gamecarsbackend.domain.entitys.Lane.Lane;
import com.example.gamecarsbackend.dto.LaneDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LaneMapper {

    public Function<LaneDTO, Lane> mapperToLane(String id){
        return updateRail -> {
            Lane lane = new Lane();
            lane.setLaneId(id);
            lane.setCarId(updateRail.getCarId());
            lane.setGameId(updateRail.getGameId());
            lane.setTrackId(updateRail.getTrackId());
            lane.setDriverId(updateRail.getDriverId());
            return lane;
        };
    }

    public Function<Lane,LaneDTO> mapperToLaneDTO(){
        return rail -> new LaneDTO(
                rail.getLaneId(),
                rail.getCarId(),
                rail.getGameId(),
                rail.getTrackId(),
                rail.getDriverId()
        );
    }
}
