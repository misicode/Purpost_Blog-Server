package com.misicode.purpost.imageservice.exception.error;

import org.springframework.http.HttpStatus;

public enum ErrorResponseEnum implements IErrorResponse {
    IMAGE_NOT_FOUND("IMAGE_NOT_FOUND", HttpStatus.NOT_FOUND, "La imagen con ID {id} no fue encontrada"),
    UPLOAD_FILE_FAILED("", HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un problema al subir el archivo, ERROR: {error}");

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
