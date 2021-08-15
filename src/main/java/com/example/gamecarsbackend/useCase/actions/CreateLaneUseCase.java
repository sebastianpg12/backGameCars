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
public class CreateLaneUseCase {

    private final LaneRepository laneRepository;
    private final LaneMapper laneMapper;

    @Autowired
    public CreateLaneUseCase(LaneRepository laneRepository, LaneMapper laneMapper) {
        this.laneMapper = laneMapper;
        this.laneRepository = laneRepository;
    }

    public Mono<LaneDTO> createLane(LaneDTO laneDTO){
        return laneRepository.save(laneMapper.mapperToLane(laneDTO.getLaneId())
                .apply(laneDTO))
                .map(laneMapper.mapperToLaneDTO());
    }
}
