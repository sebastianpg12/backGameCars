package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.TrackDTO;
import com.example.gamecarsbackend.useCase.actions.EditTrackUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EditTrackRouter {

    @Bean
    public RouterFunction<ServerResponse> editTrack(EditTrackUseCase editTrackUseCase){
        return route(PUT("/track/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TrackDTO.class)
                        .flatMap(trackDTO -> editTrackUseCase.apply(trackDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))

                        )
        );
    }
}
