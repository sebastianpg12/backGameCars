package com.example.gamecarsbackend.mapper;

import com.example.gamecarsbackend.domain.entitys.Podium.Podium;
import com.example.gamecarsbackend.dto.PodiumDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PodiumMapper {

    public Function<PodiumDTO, Podium> mapperToPodium(String id){
        return updatePodium -> {
            Podium podium = new Podium();
            podium.setPodiumId(id);
            podium.setFirstPlace(updatePodium.getFirstPlace());
            podium.setSecondPlace(updatePodium.getSecondPlace());
            podium.setThirdPlace(updatePodium.getThirdPlace());
            podium.setGameId(updatePodium.getGameId());
            return podium;
        };
    }

    public Function<Podium,PodiumDTO> mapperToPodiumDTO(){
        return podium -> new PodiumDTO(
                podium.getPodiumId(),
                podium.getFirstPlace(),
                podium.getSecondPlace(),
                podium.getThirdPlace(),
                podium.getGameId()
        );
    }
}
