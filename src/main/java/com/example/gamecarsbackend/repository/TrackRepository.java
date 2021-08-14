package com.example.gamecarsbackend.repository;


import com.example.gamecarsbackend.domain.entitys.Track.Track;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends ReactiveMongoRepository<Track, String> {
}