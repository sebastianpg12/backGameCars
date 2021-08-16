package com.example.gamecarsbackend.router.actions;


import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.useCase.actions.EditCarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EditCarRouter {

    @Bean
    public RouterFunction<ServerResponse> modifyCar(EditCarUseCase editCarUseCasee){
        return route(PUT("/car/edit").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CarDTO.class)
                        .flatMap(carDTO -> editCarUseCasee.modifyCar(carDTO)
                                .flatMap(result-> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
