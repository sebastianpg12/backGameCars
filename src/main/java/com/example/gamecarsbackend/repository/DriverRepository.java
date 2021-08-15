package com.example.gamecarsbackend.repository;

import com.example.gamecarsbackend.domain.entitys.Driver.Driver;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DriverRepository extends ReactiveMongoRepository<Driver, String> {
}
