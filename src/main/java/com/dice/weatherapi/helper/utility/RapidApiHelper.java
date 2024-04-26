package com.dice.weatherapi.helper.utility;

import com.dice.weatherapi.exception.RapidApiHelperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.net.URI;
import java.net.URL;

/**
 * Utility class for interacting with the RapidAPI service.
 */
@Component
public class RapidApiHelper {

    private static final Logger logger = LoggerFactory.getLogger(RapidApiHelper.class);

    private final RestTemplate restTemplate;

    private static final String baseUrl = "https://forecast9.p.rapidapi.com";

    /**
     * Constructor for RapidApiHelper.
     * @param restTemplate The RestTemplate instance to use for making HTTP requests.
     */
    @Autowired
    public RapidApiHelper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves the index data from RapidAPI.
     * @return Object representing the index data.
     */
    public Object getRapidApiIndex() {
        try {
            return restTemplate.exchange(new URI(baseUrl), HttpMethod.GET, null, Object.class).getBody();
        } catch (Exception exception) {
            logger.error("Error occurred while fetching RapidAPI index: {}", exception.getMessage(), exception);
            throw new RapidApiHelperException("Error occurred while fetching RapidAPI index", exception);
        }
    }

    /**
     * Retrieves the status data from RapidAPI.
     * @return Object representing the status data.
     */
    public Object getRapidApiStatus() {
        try {
            return restTemplate.exchange(new URI(String.format("%s/status", baseUrl)),
                    HttpMethod.GET, null, Object.class).getBody();
        } catch (Exception exception) {
            logger.error("Error occurred while fetching RapidAPI status: {}", exception.getMessage(), exception);
            throw new RapidApiHelperException("Error occurred while fetching RapidAPI status", exception);
        }
    }

    /**
     * Retrieves the forecast summary data for a specific location from RapidAPI.
     * @param location The name of the location for which forecast summary is requested.
     * @return Object representing the forecast summary data for the specified location.
     */
    public Object getRapidApiForecastSummaryByLocationName(String location) {
        try {
            return restTemplate.exchange(new URI(String.format("%s/rapidapi/forecast/%s/summary/", baseUrl,
                    location)), HttpMethod.GET, null, Object.class).getBody();
        } catch (Exception exception) {
            logger.error("Error occurred while fetching forecast summary for location {}: {}", location, exception.getMessage(), exception);
            throw new RapidApiHelperException("Error occurred while fetching forecast summary for location " + location
                    , exception);
        }
    }

    /**
     * Retrieves the hourly forecast data for a specific location from RapidAPI.
     * @param location The name of the location for which hourly forecast is requested.
     * @return Object representing the hourly forecast data for the specified location.
     */
    public Object getRapidApiHourlyForecastByLocationName(String location) {
        try {
            return restTemplate.exchange(new URI(String.format("%s/rapidapi/forecast/%s/hourly/",
                    baseUrl, location)), HttpMethod.GET, null, Object.class).getBody();
        } catch (Exception exception) {
            logger.error("Error occurred while fetching hourly forecast for location {}: {}", location, exception.getMessage(), exception);
            throw new RapidApiHelperException("Error occurred while fetching hourly forecast for " +
                    "location " + location, exception);
        }
    }
}