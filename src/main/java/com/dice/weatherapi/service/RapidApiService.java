package com.dice.weatherapi.service;

/**
 * Interface defining methods for interacting with the RapidAPI service.
 */
public interface RapidApiService {

    /**
     * Retrieve the index data from the RapidAPI service.
     * @return Object representing the index data.
     */
    Object getRapidApiIndex();

    /**
     * Retrieve the status data from the RapidAPI service.
     * @return Object representing the status data.
     */
    Object getRapidApiStatus();

    /**
     * Retrieve the forecast summary data for a specific location from the RapidAPI service.
     * @param location The name of the location for which forecast summary is requested.
     * @return Object representing the forecast summary data for the specified location.
     */
    Object getRapidApiForecastSummaryByLocationName(String location);

    /**
     * Retrieve the hourly forecast data for a specific location from the RapidAPI service.
     * @param location The name of the location for which hourly forecast is requested.
     * @return Object representing the hourly forecast data for the specified location.
     */
    Object getRapidApiHourlyForecastByLocationName(String location);
}