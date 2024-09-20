package com.misicode.purpost.imageservice.application.exceptions.errors;

import org.springframework.http.HttpStatus;

public enum ErrorCatalog implements Error {
    IMAGE_NOT_FOUND("IMAGE_NOT_FOUND", HttpStatus.NOT_FOUND, "La imagen con ID {id} no fue encontrada"),
    UPLOAD_FILE_FAILED("", HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un problema al subir el archivo, ERROR: {error}");

    private final String key;
    private final HttpStatus httpStatus;
    private final String message;

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
