package com.misicode.purpost.authservice.application.exceptions.errors;

import org.springframework.http.HttpStatus;

public interface Error {
    String getKey();
    String getMessage();
    HttpStatus getHttpStatus();
}
