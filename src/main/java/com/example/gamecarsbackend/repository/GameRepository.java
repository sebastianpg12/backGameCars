package com.example.gamecarsbackend.repository;


import com.example.gamecarsbackend.domain.entitys.Game.Game;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends ReactiveMongoRepository<Game, String> {
}
