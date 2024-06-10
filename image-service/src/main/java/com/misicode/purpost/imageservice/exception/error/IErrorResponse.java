package com.misicode.purpost.imageservice.exception.error;

import org.springframework.http.HttpStatus;

public interface IErrorResponse {
    String getKey();
    String getMessage();
    HttpStatus getHttpStatus();
}
