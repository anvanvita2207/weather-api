package com.dice.weatherapi.controller;

import com.dice.weatherapi.annotation.ControllerAuthorization;
import com.dice.weatherapi.exception.AuthorizationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for checking whether the application is up or not.
 */
@RestController
public class HealthCheckController {

    /**
     * Checks the health of the application by sending a dummy string message.
     */
    @ControllerAuthorization
    @GetMapping(value = "/ping")
    public String checkHealth() throws AuthorizationException {
        return "pong";
    }
}
