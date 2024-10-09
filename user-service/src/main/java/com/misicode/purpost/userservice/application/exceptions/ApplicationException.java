package com.misicode.purpost.userservice.application.exceptions;

import com.misicode.purpost.userservice.application.exceptions.errors.Error;
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

    private final transient Error error;
    private final transient Map<String, Object> messageArguments;

    public Error getError() {
        return error;
    }

    public ApplicationException(Error error) {
        this.error = error;
        this.messageArguments = Map.of();
    }

    public ApplicationException(Error error, Map<String, Object> messageArguments) {
        this.error = error;
        this.messageArguments = messageArguments;
    }

    public ApplicationException(Error error, Throwable cause) {
        super(cause);
        this.error = error;
        this.messageArguments = Map.of();
    }

    public ApplicationException(Error error, Map<String, Object> messageArguments, Throwable cause) {
        super(cause);
        this.error = error;
        this.messageArguments = messageArguments;
    }

    @Override
    public String getMessage() {
        return messageArguments.isEmpty()
                ? error.getMessage()
                : StringSubstitutor.replace(error.getMessage(), messageArguments, "{", "}");
    }

    public String getLocalizedMessage(Locale locale, MessageSource messageSource) {
        try {
            String localizedMessage = messageSource.getMessage(error.getKey(), new Object[]{}, locale);

            return messageArguments.isEmpty()
                    ? localizedMessage
                    : StringSubstitutor.replace(localizedMessage, messageArguments, "{", "}");
        } catch (NoSuchMessageException exception) {
            LOGGER.warn("Considere agregar un mensaje localizado para la clave {}", error.getKey());
        }

        return getMessage();
    }
}
