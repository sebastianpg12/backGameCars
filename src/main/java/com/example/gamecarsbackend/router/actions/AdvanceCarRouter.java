package com.example.gamecarsbackend.router.actions;

import com.example.gamecarsbackend.dto.CarDTO;
import com.example.gamecarsbackend.useCase.actions.AdvanceCarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Service
@Validated
public class AdvanceCarRouter {

    @Bean
    public RouterFunction<ServerResponse> advanceCar(AdvanceCarUseCase advanceCarUseCase) {
        return route(PUT("/car/advance/{trackDistance}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CarDTO.class)
                        .flatMap(carDTO -> advanceCarUseCase.advanceCar(carDTO, request.pathVariable("trackDistance"))
                                .flatMap(result -> ServerResponse.ok()
                                        .bodyValue(result))

                        )
        );
    }
}
