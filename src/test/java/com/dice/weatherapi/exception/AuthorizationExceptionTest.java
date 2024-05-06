package com.dice.weatherapi.exception;

/**
 * Test class for {@link AuthorizationException}.
 */
import com.dice.weatherapi.exception.AuthorizationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the behavior of {@link AuthorizationException}.
 */
class AuthorizationExceptionTest {

    /**
     * Tests the constructor of {@link AuthorizationException} and ensures that the message is correctly set.
     */
    @Test
    void testConstructorAndGetMessage() {
        // Arrange
        String errorMessage = "Authorization failed.";

        // Act
        AuthorizationException exception = new AuthorizationException(errorMessage);

        // Assert
        assertEquals(errorMessage, exception.getMessage());
    }
}
