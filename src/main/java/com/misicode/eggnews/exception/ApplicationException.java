package com.misicode.eggnews.exception;

import com.misicode.eggnews.exception.error.IErrorResponse;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;
import java.util.Map;

public class ApplicationException extends RuntimeException {
    private final IErrorResponse errorResponse;
    private final Map<String, Object> messageArguments;

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
            System.out.println("Please consider adding localized message for key "
                    + errorResponse.getKey());
        }

        return getMessage();
    }
}
