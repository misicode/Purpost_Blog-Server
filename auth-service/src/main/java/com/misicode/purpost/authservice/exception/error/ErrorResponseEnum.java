package com.misicode.purpost.authservice.exception.error;

import org.springframework.http.HttpStatus;

public enum ErrorResponseEnum implements IErrorResponse {
    AUTH_FAILED("AUTH_FAILED", HttpStatus.UNAUTHORIZED, "Acceso no autorizado: {message}");

    final String key;
    final HttpStatus httpStatus;
    final String message;

    ErrorResponseEnum(String key, HttpStatus httpStatus, String message) {
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
