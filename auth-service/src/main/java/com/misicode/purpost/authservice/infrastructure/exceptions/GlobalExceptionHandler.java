package com.misicode.purpost.authservice.infrastructure.exceptions;

import com.misicode.purpost.authservice.application.exceptions.ApplicationException;
import com.misicode.purpost.authservice.infrastructure.exceptions.utils.ConstraintsViolationError;
import com.misicode.purpost.authservice.infrastructure.exceptions.utils.HttpConstants;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ApplicationException.class)
    public Mono<Map<String, Object>> handle(ApplicationException ex,
                                            ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(ex.getError().getHttpStatus());
        return ofType(exchange, ex.getError().getHttpStatus(), ex);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public final Mono<Map<String, Object>> handle(WebExchangeBindException ex,
                                                  ServerWebExchange exchange) {
        List<ConstraintsViolationError> validationErrors = ex.getFieldErrors()
                .stream()
                .map(error -> new ConstraintsViolationError(error.getField(), error.getDefaultMessage()))
                .toList();

        String localizedMessage = messageSource.getMessage(ex.getClass().getName().concat(".message"),
                new Object[]{}, LocaleContextHolder.getLocale());

        exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
        return ofType(exchange, HttpStatus.BAD_REQUEST, localizedMessage, "INVALID_ARGUMENTS", validationErrors);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public Mono<Map<String, Object>> handle(WebClientResponseException ex,
                                            ServerWebExchange exchange) {
        String message = "Error en la comunicación con el servicio externo: " + ex.getResponseBodyAsString();
        HttpStatus status = HttpStatus.valueOf(ex.getStatusCode().value());

        exchange.getResponse().setStatusCode(status);
        return ofType(exchange, status, message, "WEBCLIENT_ERROR", Collections.emptyList());
    }

    protected Mono<Map<String, Object>> ofType(ServerWebExchange exchange,
                                               HttpStatus status,
                                               ApplicationException ex) {
        return ofType(exchange, status, ex.getLocalizedMessage(LocaleContextHolder.getLocale(), messageSource),
                ex.getError().getKey(), Collections.emptyList());
    }

    private Mono<Map<String, Object>> ofType(ServerWebExchange exchange,
                                             HttpStatus status,
                                             String message,
                                             String key,
                                             List<?> validationErrors) {
        Map<String, Object> attributes = new HashMap<>();

        attributes.put(HttpConstants.TIMESTAMP, LocalDateTime.now());
        attributes.put(HttpConstants.STATUS, status.value());
        attributes.put(HttpConstants.ERROR, status);
        attributes.put(HttpConstants.ERROR_KEY, key);
        attributes.put(HttpConstants.MESSAGE, message);
        attributes.put(HttpConstants.ERRORS, validationErrors);
        attributes.put(HttpConstants.PATH, exchange.getRequest().getURI().getPath());

        return Mono.just(attributes);
    }
}
