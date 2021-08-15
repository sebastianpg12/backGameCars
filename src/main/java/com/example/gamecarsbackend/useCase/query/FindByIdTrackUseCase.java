package com.example.gamecarsbackend.useCase.query;

import com.example.gamecarsbackend.dto.TrackDTO;
import com.example.gamecarsbackend.mapper.TrackMapper;
import com.example.gamecarsbackend.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class FindByIdTrackUseCase {

    private final TrackRepository trackRepository;
    private final TrackMapper trackMapper;

    @Autowired
    public FindByIdTrackUseCase(TrackRepository trackRepository, TrackMapper trackMapper) {
        this.trackRepository = trackRepository;
        this.trackMapper = trackMapper;
    }

    public Mono<TrackDTO> getfindbyid(String id){
        return trackRepository.findById(id)
                .flatMap(
                        track -> Mono.just(trackMapper.mapperToTrackDTO().apply(track))
                );
    }
}
