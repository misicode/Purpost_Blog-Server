package com.misicode.purpost.imageservice.application.exceptions.errors;

import org.springframework.http.HttpStatus;

public interface Error {
    String getKey();
    String getMessage();
    HttpStatus getHttpStatus();
}
