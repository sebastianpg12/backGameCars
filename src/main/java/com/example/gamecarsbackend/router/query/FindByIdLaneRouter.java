package com.example.gamecarsbackend.router.query;

import com.example.gamecarsbackend.dto.LaneDTO;
import com.example.gamecarsbackend.useCase.query.FindByIdLaneUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindByIdLaneRouter {


    @Bean
    public RouterFunction<ServerResponse> getfindbyidLane(FindByIdLaneUseCase findByIdLaneUseCase){
        return route(GET("/rail/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(findByIdLaneUseCase.getfindbyid(request.pathVariable("id")), LaneDTO.class)
        );
    }
}
