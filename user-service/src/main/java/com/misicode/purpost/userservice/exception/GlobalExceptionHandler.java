package com.misicode.purpost.userservice.exception;

import com.misicode.purpost.userservice.constants.HttpConstants;
import com.misicode.purpost.userservice.exception.error.ConstraintsViolationError;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

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
        exchange.getResponse().setStatusCode(ex.getErrorResponse().getHttpStatus());
        return ofType(exchange, ex.getErrorResponse().getHttpStatus(), ex);
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

    protected Mono<Map<String, Object>> ofType(ServerWebExchange exchange,
                                                         HttpStatus status,
                                                         ApplicationException ex) {
        return ofType(exchange, status, ex.getLocalizedMessage(LocaleContextHolder.getLocale(), messageSource),
                ex.getErrorResponse().getKey(), Collections.emptyList());
    }

    private Mono<Map<String, Object>> ofType(ServerWebExchange exchange,
                                             HttpStatus status,
                                             String message,
                                             String key,
                                             List<?> validationErrors) {
        Map<String, Object> attributes = new HashMap<>();

        attributes.put(HttpConstants.STATUS, status.value());
        attributes.put(HttpConstants.ERROR, status);
        attributes.put(HttpConstants.ERROR_KEY, key);
        attributes.put(HttpConstants.MESSAGE, message);
        attributes.put(HttpConstants.ERRORS, validationErrors);
        attributes.put(HttpConstants.PATH, exchange.getRequest().getURI().getPath());

        return Mono.just(attributes);
    }
}