package com.misicode.purpost.postservice.application.exceptions.errors;

import org.springframework.http.HttpStatus;

public enum ErrorCatalog implements Error {
    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NOT_FOUND, "El nombre de usuario {username} no fue encontrado"),
    POST_NOT_FOUND( "POST_NOT_FOUND", HttpStatus.NOT_FOUND , "La publicación con ID {id} no fue encontrada");

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
