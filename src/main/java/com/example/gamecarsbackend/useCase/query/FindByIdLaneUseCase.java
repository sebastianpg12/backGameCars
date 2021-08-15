package com.example.gamecarsbackend.useCase.query;


import com.example.gamecarsbackend.dto.LaneDTO;
import com.example.gamecarsbackend.mapper.LaneMapper;
import com.example.gamecarsbackend.repository.LaneRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByIdLaneUseCase {

    private final LaneRepository laneRepository;
    private final LaneMapper laneMapper;

    public FindByIdLaneUseCase(LaneRepository laneRepository, LaneMapper laneMapper) {
        this.laneRepository = laneRepository;
        this.laneMapper = laneMapper;
    }

    public Mono<LaneDTO> getfindbyid(String id){
        return laneRepository.findById(id)
                .flatMap(
                        rail -> Mono.just(laneMapper.mapperToLaneDTO().apply(rail))
                );
    }
}
