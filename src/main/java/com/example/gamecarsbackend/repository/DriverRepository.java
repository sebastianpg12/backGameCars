package com.example.gamecarsbackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.sql.Driver;

@Repository
public interface DriverRepository extends ReactiveMongoRepository<Driver, String> {
}
