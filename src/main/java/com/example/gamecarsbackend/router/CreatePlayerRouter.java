package com.example.gamecarsbackend.router;

import com.example.gamecarsbackend.dto.PlayerDTO;
import com.example.gamecarsbackend.useCase.CreatePlayerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreatePlayerRouter {

    @Bean
    public RouterFunction<ServerResponse> createPlayer(CreatePlayerUseCase createPlayerUseCase){
        return route(POST("/create/player").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PlayerDTO.class)
                        .flatMap(playerDTO -> createPlayerUseCase.apply(playerDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)
                                )
                        )
        );
    }
}