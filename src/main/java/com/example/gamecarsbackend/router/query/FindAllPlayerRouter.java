package com.example.gamecarsbackend.router.query;


import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.useCase.query.FindAllPlayerUseCase;
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
public class FindAllPlayerRouter {

    @Bean
    public RouterFunction<ServerResponse> findAll(FindAllPlayerUseCase findAllPlayerUseCase){
        return route(GET("/get/players").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllPlayerUseCase.findAll(), PlayerDTO.class))
        );
    }
}
