package com.example.gamecarsbackend.repository;

import com.example.gamecarsbackend.domain.entitys.Car.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CarRepository extends ReactiveMongoRepository<Car, String> {
    Flux<Car> findByDriverId(String driverId);
}
