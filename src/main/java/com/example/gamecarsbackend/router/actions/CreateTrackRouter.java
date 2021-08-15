package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.TrackDTO;
import com.example.gamecarsbackend.useCase.actions.CreateTrackUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class CreateTrackRouter {

    @Bean
    public RouterFunction<ServerResponse> createTrack(CreateTrackUseCase createTrackUseCase) {
        return route(POST("/create/track").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TrackDTO.class)
                        .flatMap(trackDTO -> createTrackUseCase.apply(trackDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))

                        )
        );
    }
}
