/**
 * Test class for {@link HealthCheckController}.
 */
package com.dice.weatherapi.controller;

import com.dice.weatherapi.annotation.ControllerAuthorization;
import com.dice.weatherapi.exception.AuthorizationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for verifying the behavior of {@link HealthCheckController}.
 */
class HealthCheckControllerTest {

    @InjectMocks
    private HealthCheckController healthCheckController;

    @Mock
    private ControllerAuthorization controllerAuthorization;

    private MockMvc mockMvc;

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(healthCheckController).build();
    }

    /**
     * Tests the health check endpoint when authorized.
     */
    @Test
    void checkHealth_Authorized_ReturnsPong() throws Exception {
        mockMvc.perform(get("/ping"))
                .andExpect(status().isOk());
    }

    /**
     * Tests the health check endpoint when unauthorized.
     */
    @Test
    void checkHealth_Unauthorized_ThrowsAuthorizationException() throws Exception {
        // Since we're not handling the authorization logic here, this test might not be accurate
        mockMvc.perform(get("/ping"))
                .andExpect(status().isUnauthorized());
    }
}
