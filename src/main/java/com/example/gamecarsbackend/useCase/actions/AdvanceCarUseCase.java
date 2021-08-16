package com.example.gamecarsbackend.useCase.actions;

import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.mapper.CarMapper;
import com.example.gamecarsbackend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class AdvanceCarUseCase {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public AdvanceCarUseCase(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public Mono<CarDTO> advanceCar(CarDTO carDTO, String trackDistance) {
        carDTO.advanceCar(trackDistance);

        return carRepository
                .save(carMapper.mapperToCar(carDTO.getCarId())
                        .apply(carDTO))
                .map(carMapper.mappertoCarDTO());
    }
}