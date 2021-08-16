package com.example.gamecarsbackend.useCase.query;

import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.mapper.CarMapper;
import com.example.gamecarsbackend.mapper.PlayerMapper;
import com.example.gamecarsbackend.repository.CarRepository;
import com.example.gamecarsbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetCarByGameIdUseCase {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public GetCarByGameIdUseCase(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public Flux<CarDTO> findCarsByGameId(String gameId) {
        return carRepository.findByGameId(gameId)
                .flatMap(car -> Flux.just(carMapper.mappertoCarDTO().apply(car)));
    }
}
