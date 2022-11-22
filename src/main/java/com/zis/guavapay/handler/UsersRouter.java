package com.zis.guavapay.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@RequiredArgsConstructor
public class UsersRouter {

    private final CreateUserHandler create;
    private final ModifyUserHandler modify;

    @Bean
    public RouterFunction<ServerResponse> validateRouter() {
        return RouterFunctions
                .route(POST("/users/new").and(accept(MediaType.APPLICATION_JSON)), create::handleRequest)
                .andRoute(POST("/users/update").and(accept(MediaType.APPLICATION_JSON)), modify::handleRequest);
    }
}