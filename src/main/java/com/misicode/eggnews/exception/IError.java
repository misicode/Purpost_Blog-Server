package com.misicode.eggnews.exception;

import org.springframework.http.HttpStatus;

public interface IError {
    String getKey();
    String getMessage();
    HttpStatus getHttpStatus();
}
