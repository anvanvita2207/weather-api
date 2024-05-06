/**
 * Test class for {@link SecurityAspect}.
 */
package com.dice.weatherapi.aspect;

import com.dice.weatherapi.exception.AuthorizationException;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Test class for verifying the behavior of {@link SecurityAspect}.
 */
class SecurityAspectTest {

    private SecurityAspect securityAspect;

    @Mock
    private HttpServletRequest mockRequest;

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        securityAspect = new SecurityAspect();
    }

    /**
     * Tests the authorization process when a valid token is provided.
     */
    @Test
    void authorizeController_ValidToken_NoExceptionThrown() {
        when(mockRequest.getHeader("Auth-Token")).thenReturn("valid_token");
        ServletRequestAttributes attributes = new ServletRequestAttributes(mockRequest);
        RequestContextHolder.setRequestAttributes(attributes);

        assertDoesNotThrow(() -> securityAspect.authorizeController());
    }

    /**
     * Tests the authorization process when an invalid token is provided.
     */
    @Test
    void authorizeController_InvalidToken_ExceptionThrown() {
        when(mockRequest.getHeader("Auth-Token")).thenReturn("invalid_token");
        ServletRequestAttributes attributes = new ServletRequestAttributes(mockRequest);
        RequestContextHolder.setRequestAttributes(attributes);

        assertThrows(AuthorizationException.class, () -> securityAspect.authorizeController());
    }
}
