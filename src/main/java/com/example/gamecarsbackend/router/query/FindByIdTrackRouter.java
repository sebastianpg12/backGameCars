package com.example.gamecarsbackend.router.query;


import com.example.gamecarsbackend.dto.TrackDTO;
import com.example.gamecarsbackend.useCase.query.FindByIdTrackUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindByIdTrackRouter {

    @Bean
    public RouterFunction<ServerResponse> getfindbyidtrack(FindByIdTrackUseCase findByIdTrackUseCase){
        return route(GET("/track/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(findByIdTrackUseCase.getfindbyid(request.pathVariable("id")), TrackDTO.class)
        );
    }
}