package com.example.gamecarsbackend.repository;


import com.example.gamecarsbackend.domain.entitys.Podium.Podium;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodiumRepository extends ReactiveMongoRepository<Podium, String> {
}
