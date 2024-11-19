package com.misicode.purpost.authservice.infrastructure.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.misicode.purpost.authservice.application.exceptions.ApplicationException;
import com.misicode.purpost.authservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.authservice.infrastructure.exceptions.utils.HttpConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class AuthEntryPoint implements ServerAuthenticationEntryPoint {
    @Override
    public Mono<Void> commence (ServerWebExchange exchange,
                                AuthenticationException authException) {
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        Map<String, Object> body = Map.of(
                HttpConstants.TIMESTAMP, ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                HttpConstants.STATUS, HttpStatus.UNAUTHORIZED,
                HttpConstants.ERROR, "UNAUTHORIZED",
                HttpConstants.ERROR_KEY, "AUTH_EXCEPTION",
                HttpConstants.MESSAGE, "Operación inválida",
                HttpConstants.PATH, exchange.getRequest().getPath().value()
        );

        return exchange
                .getResponse()
                .writeWith(Mono.fromSupplier(() -> {
                    try {
                        byte[] bytes = new ObjectMapper().writeValueAsBytes(body);
                        return exchange.getResponse().bufferFactory().wrap(bytes);
                    } catch (JsonProcessingException e) {
                        throw new ApplicationException(ErrorCatalog.ERROR_RESPONSE);
                    }
                }));
    }
}
