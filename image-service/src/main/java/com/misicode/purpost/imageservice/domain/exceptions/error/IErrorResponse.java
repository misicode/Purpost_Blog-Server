package com.misicode.purpost.imageservice.domain.exceptions.error;

import org.springframework.http.HttpStatus;

public interface IErrorResponse {
    String getKey();
    String getMessage();
    HttpStatus getHttpStatus();
}
