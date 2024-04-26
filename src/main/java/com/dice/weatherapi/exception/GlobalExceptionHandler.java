package com.dice.weatherapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling exceptions thrown within the application.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles RapidApiServiceException and returns a ResponseEntity with appropriate error message and status code.
     * @param rapidApiHelperException RapidApiServiceException instance.
     * @return ResponseEntity containing error message and status code.
     */
    @ExceptionHandler(RapidApiHelperException.class)
    public ResponseEntity<String> handleRapidApiServiceException(RapidApiHelperException rapidApiHelperException) {
        logger.error("RapidAPI Helper Exception: {}", rapidApiHelperException.getMessage(),
                rapidApiHelperException);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rapidApiHelperException.getMessage());
    }

    /**
     * Handles other exceptions and returns a ResponseEntity with appropriate error message and status code.
     * @param exception Exception instance.
     * @return ResponseEntity containing error message and status code.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        logger.error("Internal Server Error: {}", exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
}
