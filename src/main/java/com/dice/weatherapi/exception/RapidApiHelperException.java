package com.dice.weatherapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom exception class for RapidAPI service errors.
 */
public class RapidApiHelperException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(RapidApiHelperException.class);

    /**
     * Constructs a new RapidApiServiceException with the specified detail message.
     * @param message the detail message.
     */
    public RapidApiHelperException(String message) {
        super(message);
    }

    /**
     * Constructs a new RapidApiServiceException with the specified detail message and cause.
     * @param message the detail message.
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
     */
    public RapidApiHelperException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message, cause.getMessage());
    }
}
