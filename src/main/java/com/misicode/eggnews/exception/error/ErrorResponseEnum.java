package com.misicode.eggnews.exception.error;

import org.springframework.http.HttpStatus;

public enum ErrorResponseEnum implements IErrorResponse {
    NEWS_NOT_FOUND( "NEWS_NOT_FOUND", HttpStatus.NOT_FOUND , "La noticia con ID {id} no fue encontrada");

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
