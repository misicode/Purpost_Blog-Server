package com.misicode.purpost.imageservice.application.exceptions;

import com.misicode.purpost.imageservice.application.exceptions.errors.Error;
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

    private final transient Error errorResponse;
    private final transient Map<String, Object> messageArguments;

    public Error getErrorResponse() {
        return errorResponse;
    }

    public ApplicationException(Error errorResponse) {
        this.errorResponse = errorResponse;
        this.messageArguments = Map.of();
    }

    public ApplicationException(Error errorResponse, Map<String, Object> messageArguments) {
        this.errorResponse = errorResponse;
        this.messageArguments = messageArguments;
    }

    public ApplicationException(Error errorResponse, Throwable cause) {
        super(cause);
        this.errorResponse = errorResponse;
        this.messageArguments = Map.of();
    }

    public ApplicationException(Error errorResponse, Map<String, Object> messageArguments, Throwable cause) {
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
