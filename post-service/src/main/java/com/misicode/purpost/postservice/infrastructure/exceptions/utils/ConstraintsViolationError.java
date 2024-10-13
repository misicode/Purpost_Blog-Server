package com.misicode.purpost.postservice.infrastructure.exceptions.utils;

public class ConstraintsViolationError {
    private String property;
    private String message;

    public ConstraintsViolationError(String property, String message) {
        this.property = property;
        this.message = message;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}