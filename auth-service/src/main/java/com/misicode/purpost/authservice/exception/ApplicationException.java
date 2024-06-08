package com.misicode.purpost.authservice.exception;

import com.misicode.purpost.authservice.exception.error.IErrorResponse;
import org.apache.commons.text.StringSubstitutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public class ApplicationException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationException.class);

    private final transient IErrorResponse errorResponse;
    private final transient Map<String, Object> messageArguments;

    public IErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public ApplicationException(IErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
        this.messageArguments = Map.of();
    }

    public ApplicationException(IErrorResponse errorResponse, Map<String, Object> messageArguments) {
        this.errorResponse = errorResponse;
        this.messageArguments = messageArguments;
    }

    public ApplicationException(IErrorResponse errorResponse, Throwable cause) {
        super(cause);
        this.errorResponse = errorResponse;
        this.messageArguments = Map.of();
    }

    public ApplicationException(IErrorResponse errorResponse, Map<String, Object> messageArguments, Throwable cause) {
        super(cause);
        this.errorResponse = errorResponse;
        this.messageArguments = messageArguments;
    }

    @Override
    public String getMessage() {
        return messageArguments.isEmpty()
                ? errorResponse.getMessage()
                : StringSubstitutor.replace(errorResponse.getMessage(), messageArguments, "{", "}");
    }

    public String getLocalizedMessage(Locale locale, MessageSource messageSource) {
        try {
            String localizedMessage = messageSource.getMessage(errorResponse.getKey(), new Object[]{}, locale);

            return messageArguments.isEmpty()
                    ? localizedMessage
                    : StringSubstitutor.replace(localizedMessage, messageArguments, "{", "}");
        } catch (NoSuchMessageException exception) {
            LOGGER.warn("Considere agregar un mensaje localizado para la clave {}", errorResponse.getKey());
        }

        return getMessage();
    }
}
