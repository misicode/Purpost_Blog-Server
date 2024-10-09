package com.misicode.purpost.userservice.application.exceptions.errors;

import org.springframework.http.HttpStatus;

public enum ErrorCatalog implements Error {
    USER_EXISTS("USER_EXISTS", HttpStatus.CONFLICT, "El {id} {value} ya se encuentra registrado"),
    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NOT_FOUND, "El {id} {value} no fue encontrado");

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
