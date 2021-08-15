package com.example.gamecarsbackend.mapper;


import com.example.gamecarsbackend.domain.entitys.Track.Track;
import com.example.gamecarsbackend.dto.TrackDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackMapper {

    public Function<TrackDTO, Track> mapperToTrack(String id){
        return  updateTrack -> {
            Track track = new Track();
            track.setTrackId(id);
            track.setTrackDistance(updateTrack.getTrackDistance());
            track.setGameId(updateTrack.getGameId());
            track.setPodiumId(updateTrack.getPodiumId());
            return track;
        };
    }

    public Function<Track,TrackDTO> mapperToTrackDTO(){
        return track -> new TrackDTO(
                track.getTrackId(),
                track.getTrackDistance(),
                track.getGameId(),
                track.getPodiumId()
        );
    }
}