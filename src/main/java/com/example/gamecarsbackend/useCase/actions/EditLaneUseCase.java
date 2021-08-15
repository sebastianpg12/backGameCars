package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.dto.LaneDTO;
import com.example.gamecarsbackend.mapper.LaneMapper;
import com.example.gamecarsbackend.repository.LaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;


@Service
@Validated
public class EditLaneUseCase {

    private final LaneRepository laneRepository;
    private final LaneMapper laneMapper;

    @Autowired
    public EditLaneUseCase(LaneRepository laneRepository, LaneMapper laneMapper) {
        this.laneRepository = laneRepository;

        this.laneMapper = laneMapper;
    }
    public Mono<LaneDTO> apply(LaneDTO laneDTO){
        return laneRepository.save(laneMapper.mapperToLane(laneDTO.getLaneId())
                        .apply(laneDTO))
                .map(laneMapper.mapperToLaneDTO());
    }
}
