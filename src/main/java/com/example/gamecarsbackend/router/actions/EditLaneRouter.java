package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.LaneDTO;
import com.example.gamecarsbackend.useCase.actions.EditLaneUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EditLaneRouter {

    @Bean
    public RouterFunction<ServerResponse> editRail(EditLaneUseCase editRailUseCase) {
        return route(PUT("/rail/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(LaneDTO.class)
                        .flatMap(railDTO -> editRailUseCase.apply(railDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))
                        )
        );
    }
}