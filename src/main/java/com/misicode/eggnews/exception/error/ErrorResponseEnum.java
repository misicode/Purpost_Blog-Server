package com.misicode.eggnews.exception.error;

import org.springframework.http.HttpStatus;

public enum ErrorResponseEnum implements IErrorResponse {
    AUTH_FAILED("AUTH_FAILED", HttpStatus.UNAUTHORIZED, "Acceso no autorizado: {message}"),
    INVALID_TOKEN("INVALID_TOKEN", HttpStatus.UNAUTHORIZED, "El token ha caducado: {message}"),
    NEWS_NOT_FOUND( "NEWS_NOT_FOUND", HttpStatus.NOT_FOUND , "La noticia con ID {id} no fue encontrada"),
    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NOT_FOUND, "El usuario con correo {email} no fue encontrado");

    String key;
    HttpStatus httpStatus;
    String message;

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
