package com.zis.guavapay.handler;

import com.zis.guavapay.handler.normalization.UserNormalizer;
import com.zis.guavapay.handler.validation.CreateUserValidator;
import com.zis.guavapay.model.dto.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CreateUserHandler extends AbstractHandler<User, CreateUserValidator> {

    private CreateUserHandler() {
        super(User.class, new CreateUserValidator(), new UserNormalizer());
    }

    @Override
    protected Mono<ServerResponse> processBody(User validBody, ServerRequest originalRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.justOrEmpty(validBody), User.class);
    }
}
