package com.zis.guavapay.handler;

import com.zis.guavapay.handler.normalization.Normalizer;
import com.zis.guavapay.model.dto.ErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

public abstract class AbstractHandler<T, V extends Validator> {
    private final Class<T> validationClass;
    private final V validator;
    private final Normalizer<T> normalizer;

    protected AbstractHandler(Class<T> validationClass, V validator, Normalizer<T> normalizer) {
        this.validationClass = validationClass;
        this.validator = validator;
        this.normalizer = normalizer;
    }

    public final Mono<ServerResponse> handleRequest(final ServerRequest request) {
        return request.bodyToMono(this.validationClass)
                .flatMap(body -> {
                    Errors errors = new BeanPropertyBindingResult(body, this.validationClass.getName());
                    this.validator.validate(body, errors);
                    if (errors.getAllErrors().isEmpty()) {
                        return processBody(normalizer.normalize(body), request);
                    } else {
                        return onValidationErrors(errors, body, request);
                    }
                });
    }

    abstract protected Mono<ServerResponse> processBody(T validBody, ServerRequest originalRequest);

    protected Mono<ServerResponse> onValidationErrors(Errors errors, T invalidBody, ServerRequest request) {
        return ServerResponse
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.justOrEmpty(new ErrorResponse(
                                errors.getFieldErrors()
                                        .stream().map(FieldError::getField)
                                        .collect(Collectors.toList())))
                        , ErrorResponse.class);
    }
}
