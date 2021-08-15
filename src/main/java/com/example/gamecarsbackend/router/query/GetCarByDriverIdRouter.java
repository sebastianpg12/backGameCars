package com.example.gamecarsbackend.router.query;

import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.useCase.query.GetCarByDriverIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Service
@Validated
public class GetCarByDriverIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findCarByDriverId(GetCarByDriverIdUseCase findCarsByDriverIdUseCase){
        return route(GET("/car/driver/{driverId}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findCarsByDriverIdUseCase.findCarsByDriverId(request.pathVariable("gameid")), CarDTO.class))
        );
    }
}
