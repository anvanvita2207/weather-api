package com.dice.weatherapi.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for RapidApiHelperException.
 */
public class RapidApiHelperExceptionTest {

    /**
     * Test for constructing RapidApiHelperException with message.
     */
    @Test
    public void testConstructorWithMessage() {
        String message = "Test message";
        RapidApiHelperException exception = new RapidApiHelperException(message);
        assertEquals(message, exception.getMessage());
    }

    /**
     * Test for constructing RapidApiHelperException with message and cause.
     */
    @Test
    public void testConstructorWithMessageAndCause() {
        String message = "Test message";
        Throwable cause = new Throwable("Test cause");
        RapidApiHelperException exception = new RapidApiHelperException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}

