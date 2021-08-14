package com.example.gamecarsbackend.repository;

import com.example.gamecarsbackend.domain.entitys.Lane.Lane;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface LaneRepository extends ReactiveMongoRepository<Lane, String> {
    Flux<Lane> findByTrackId(String id);
}

