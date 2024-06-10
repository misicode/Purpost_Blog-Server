package com.misicode.purpost.userservice.exception.error;

import org.springframework.http.HttpStatus;

public enum ErrorResponseEnum implements IErrorResponse {
    USER_EXISTS("USER_EXISTS", HttpStatus.CONFLICT, "El usuario con correo {email} ya se encuentra registrado"),
    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NOT_FOUND, "El usuario con {id} {value} no fue encontrado");

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
