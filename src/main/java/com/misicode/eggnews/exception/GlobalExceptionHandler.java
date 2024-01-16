package com.misicode.eggnews.exception;

import com.misicode.eggnews.constants.HttpConstants;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends DefaultErrorAttributes {
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Map<String, Object>> handle(ApplicationException ex,
                                                      WebRequest request) {
        return ofType(request, ex.getErrorResponse().getHttpStatus(), ex);
    }

    protected ResponseEntity<Map<String, Object>> ofType(WebRequest request,
                                                         HttpStatus status,
                                                         ApplicationException ex) {
        return ofType(request, status, ex.getLocalizedMessage(LocaleContextHolder.getLocale(), messageSource),
                ex.getErrorResponse().getKey(), Collections.EMPTY_LIST);
    }

    private ResponseEntity<Map<String, Object>> ofType(WebRequest request,
                                                       HttpStatus status,
                                                       String message,
                                                       String key,
                                                       List validationErrors) {
        Map<String, Object> attributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        attributes.put(HttpConstants.STATUS, status.value());
        attributes.put(HttpConstants.ERROR, status);
        attributes.put(HttpConstants.ERROR_KEY, key);
        attributes.put(HttpConstants.MESSAGE, message);
        attributes.put(HttpConstants.ERRORS, validationErrors);
        attributes.put(HttpConstants.PATH, ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(attributes, status);
    }
}
