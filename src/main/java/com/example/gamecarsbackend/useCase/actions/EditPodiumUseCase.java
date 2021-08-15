package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.dto.PodiumDTO;
import com.example.gamecarsbackend.mapper.PodiumMapper;
import com.example.gamecarsbackend.repository.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;


@Service
@Validated
public class EditPodiumUseCase {

    private final PodiumRepository podiumRepository;
    private final PodiumMapper podiumMapper;

    @Autowired
    public EditPodiumUseCase(PodiumRepository podiumRepository, PodiumMapper podiumMapper) {
        this.podiumRepository = podiumRepository;

        this.podiumMapper = podiumMapper;
    }

    public Mono<PodiumDTO> apply(PodiumDTO podiumDTO) {
        return podiumRepository.save(podiumMapper.mapperToPodium(podiumDTO.getPodiumId())
                        .apply(podiumDTO))
                .map(podiumMapper.mapperToPodiumDTO());
    }
}
