package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.GameDTO;
import com.example.gamecarsbackend.useCase.actions.EditGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EditGameRouter {

    @Bean
    public RouterFunction<ServerResponse> modifyGame(EditGameUseCase editGameUseCase){
        return route(PUT("/game/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(GameDTO.class)
                        .flatMap(gameDTO -> {
                                    return editGameUseCase.modifyGame(gameDTO)
                                            .flatMap(result -> ServerResponse.ok()
                                                    .bodyValue(result));
                                }
                        )
        );
    }
}