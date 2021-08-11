package com.example.gamecarsbackend.repository;


import com.example.gamecarsbackend.domain.entitys.Game.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {
    }

