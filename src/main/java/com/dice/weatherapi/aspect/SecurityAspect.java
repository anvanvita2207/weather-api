/**
 * AOP Aspect for handling security related concerns in the application.
 */
package com.dice.weatherapi.aspect;

import com.dice.weatherapi.exception.AuthorizationException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * AOP aspect responsible for enforcing authorization checks on controllers.
 */
@Aspect
@Component
public class SecurityAspect {

    /**
     * Value injected from the application properties file representing the expected authentication token.
     */
    @Value("${auth.token}")
    private String authToken;

    /**
     * Advice method executed before methods annotated with {@link com.dice.weatherapi.annotation.ControllerAuthorization}.
     * Verifies the authenticity of the incoming request by comparing the provided authentication token.
     * Throws an AuthorizationException if the token is invalid.
     */
    @Before("@annotation(com.dice.weatherapi.annotation.ControllerAuthorization)")
    public void authorizeController() {
        HttpServletRequest httpServletRequest =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String authHeader = httpServletRequest.getHeader("Auth-Token");

        if (!authToken.equals(authHeader)) {
            throw new AuthorizationException("Auth Token invalid");
        }
    }
}