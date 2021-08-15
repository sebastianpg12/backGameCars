package com.example.gamecarsbackend.useCase.query;


import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.mapper.CarMapper;
import com.example.gamecarsbackend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetCarByDriverIdUseCase {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public GetCarByDriverIdUseCase(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public Flux<CarDTO> findCarsByDriverId(String id){
        return carRepository.findByDriverId(id)
                .flatMap(
                        car -> Flux.just(carMapper.mappertoCarDTO().apply(car))
                );
    }
}
