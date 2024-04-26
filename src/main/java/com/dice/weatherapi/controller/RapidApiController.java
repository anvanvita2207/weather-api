package com.dice.weatherapi.controller;

import com.dice.weatherapi.service.RapidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling requests related to RapidAPI weather data.
 */
@RestController
@RequestMapping(value = "/rapid")
@Validated
public class RapidApiController {

    /**
     * The service responsible for handling requests related to the RapidAPI weather data.
     */
    private final RapidApiService rapidApiService;

    /**
     * Constructor for the RapidApiController class.
     * @param rapidApiService The service responsible for handling RapidAPI requests.
     */
    @Autowired
    public RapidApiController(RapidApiService rapidApiService) {
        this.rapidApiService = rapidApiService;
    }

    /**
     * Retrieves the index of RapidAPI.
     * @return ResponseEntity containing the index data.
     */
    @GetMapping(value = "/index")
    public ResponseEntity<Object> getRapidApiIndex() throws Exception{
        Object indexData = rapidApiService.getRapidApiIndex();
        return ResponseEntity.ok(indexData);
    }

    /**
     * Retrieves the status of RapidAPI.
     * @return ResponseEntity containing the status data.
     */
    @GetMapping(value = "/status")
    public ResponseEntity<Object> getRapidApiStatus() throws Exception{
        Object statusData = rapidApiService.getRapidApiStatus();
        return ResponseEntity.ok(statusData);

    }

    /**
     * Retrieves the forecast summary for a specific location.
     * @param location The name of the location for which forecast summary is requested.
     * @return ResponseEntity containing the forecast summary data.
     */
    @GetMapping(value = "/summary/{location}")
    public ResponseEntity<Object> getForecastSummaryByLocationName(@PathVariable String location) throws Exception{
        Object summaryData = rapidApiService.getRapidApiForecastSummaryByLocationName(location);
        return ResponseEntity.ok(summaryData);
    }

    /**
     * Retrieves the hourly forecast for a specific location.
     * @param location The name of the location for which hourly forecast is requested.
     * @return ResponseEntity containing the hourly forecast data.
     */
    @GetMapping(value = "/hourly/{location}")
    public ResponseEntity<Object> getHourlyForecastByLocationName(@PathVariable String location) throws Exception{
        Object hourlyData = rapidApiService.getRapidApiHourlyForecastByLocationName(location);
        return ResponseEntity.ok(hourlyData);
    }
}
