package com.misicode.purpost.authservice.application.exceptions.errors;

import org.springframework.http.HttpStatus;

public enum ErrorCatalog implements Error {
    AUTH_FAILED("AUTH_FAILED", HttpStatus.UNAUTHORIZED, "Acceso no autorizado: {message}"),
    INVALID_TOKEN("INVALID_TOKEN", HttpStatus.UNAUTHORIZED, "Token inválido");

    final String key;
    final HttpStatus httpStatus;
    final String message;

    ErrorCatalog(String key, HttpStatus httpStatus, String message) {
        this.message = message;
        this.key = key;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
