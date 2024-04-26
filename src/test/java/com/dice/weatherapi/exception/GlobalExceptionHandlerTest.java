package com.dice.weatherapi.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test class for GlobalExceptionHandler.
 */
public class GlobalExceptionHandlerTest {

    @Mock
    private Logger logger;

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test handling RapidApiHelperException.
     */
    @Test
    public void testHandleRapidApiServiceException() {
        RapidApiHelperException exception = new RapidApiHelperException("RapidAPI Service Exception");
        ResponseEntity<String> response = globalExceptionHandler.handleRapidApiServiceException(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("RapidAPI Service Exception", response.getBody());
        verify(logger).error("RapidAPI Service Exception: {}", exception.getMessage(), exception);
    }

    /**
     * Test handling generic Exception.
     */
    @Test
    public void testHandleException() {
        Exception exception = new Exception("Internal Server Error");
        ResponseEntity<String> response = globalExceptionHandler.handleException(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal Server Error", response.getBody());
        verify(logger).error("Internal Server Error: {}", exception.getMessage(), exception);
    }
}

