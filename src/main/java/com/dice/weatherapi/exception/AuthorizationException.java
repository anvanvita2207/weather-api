package com.dice.weatherapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom exception class for Authorization related errors.
 */
public class AuthorizationException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(RapidApiHelperException.class);
    /**
     * Constructs a new AuthorizationException with the specified detail message.
     * @param message the detail message.
     */
    public AuthorizationException(String message) {
        super(message);
    }
}
