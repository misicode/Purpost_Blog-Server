package com.misicode.purpost.postservice.exception.error;

import org.springframework.http.HttpStatus;

public enum ErrorResponseEnum implements IErrorResponse {
    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NOT_FOUND, "El usuario con correo {email} no fue encontrado"),
    POST_NOT_FOUND( "POST_NOT_FOUND", HttpStatus.NOT_FOUND , "La publicación con ID {id} no fue encontrada");

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
