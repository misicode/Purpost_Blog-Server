package com.misicode.eggnews.exception;

import org.springframework.http.HttpStatus;

public enum ErrorEnum implements ErrorResponse {
    NEWS_NOT_FOUND( "NEWS_NOT_FOUND", HttpStatus.NOT_FOUND , "No se encontró la noticia con ID {id}");

    String key;
    HttpStatus httpStatus;
    String message;

    ErrorEnum(String key, HttpStatus httpStatus, String message) {
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
