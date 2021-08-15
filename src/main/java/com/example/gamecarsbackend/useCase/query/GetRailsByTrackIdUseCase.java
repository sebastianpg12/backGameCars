package com.example.gamecarsbackend.useCase.query;

import com.example.gamecarsbackend.dto.LaneDTO;
import com.example.gamecarsbackend.mapper.LaneMapper;
import com.example.gamecarsbackend.repository.LaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetRailsByTrackIdUseCase {

    private final LaneRepository laneRepository;
    private final LaneMapper laneMapper;

    @Autowired
    public GetRailsByTrackIdUseCase(LaneRepository laneRepository, LaneMapper laneMapper) {
        this.laneRepository = laneRepository;
        this.laneMapper = laneMapper;
    }

    public Flux<LaneDTO> getRailByTrackId(String id){
        return laneRepository.findByTrackId(id)
                .flatMap(
                        lane -> Flux.just(laneMapper.mapperToLaneDTO().apply(lane))
                );
    }
}
