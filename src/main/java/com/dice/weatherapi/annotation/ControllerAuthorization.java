/**
 * Annotation to mark controller methods requiring authorization checks.
 */
package com.dice.weatherapi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method requires authorization checks.
 * Typically used on controller methods to enforce authentication before execution.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerAuthorization {
}
