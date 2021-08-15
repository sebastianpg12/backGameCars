package com.example.gamecarsbackend.router.query;

import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.useCase.query.FindByIdCarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindByIdCarRouter {

    @Bean
    public RouterFunction<ServerResponse> findByIdCar(FindByIdCarUseCase findByIdCarUseCase){
        return route(GET("/car/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findByIdCarUseCase.findById(request.pathVariable("id")), CarDTO.class))
        );
    }
}
