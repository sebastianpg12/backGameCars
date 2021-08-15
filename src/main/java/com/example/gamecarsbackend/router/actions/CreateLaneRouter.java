package com.example.gamecarsbackend.router.actions;


import com.example.gamecarsbackend.dto.LaneDTO;
import com.example.gamecarsbackend.useCase.actions.CreateLaneUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateLaneRouter {

    @Bean
    public RouterFunction<ServerResponse> createLane(CreateLaneUseCase createRailUseCase) {
        return route(POST("/lane/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(LaneDTO.class)
                        .flatMap(railDTO -> createRailUseCase.createLane(railDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
