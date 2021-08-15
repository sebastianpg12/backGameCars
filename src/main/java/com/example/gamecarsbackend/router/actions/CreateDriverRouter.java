package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.DriverDTO;
import com.example.gamecarsbackend.useCase.actions.CreateDriverUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateDriverRouter {

    @Bean
    public RouterFunction<ServerResponse> createDriver(CreateDriverUseCase createDriverUseCase){
        return  route(POST("/driver/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(DriverDTO.class)
                        .flatMap(driverDTO -> createDriverUseCase.apply(driverDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
