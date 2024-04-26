package com.dice.weatherapi.service.serviceImpl;

import com.dice.weatherapi.helper.utility.RapidApiHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the RapidApiServiceImplementation class.
 */
class RapidApiServiceImplementationTest {

    @Mock
    private RapidApiHelper rapidApiHelper;

    @InjectMocks
    private RapidApiServiceImplementation rapidApiService;

    /**
     * Initializes Mockito annotations before each test method.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test case for successful retrieval of RapidAPI index data.
     */
    @Test
    void getRapidApiIndex() {
        when(rapidApiHelper.getRapidApiIndex()).thenReturn("Index Data");
        Object result = rapidApiService.getRapidApiIndex();
        assertEquals("Index Data", result);
    }

    /**
     * Test case for successful retrieval of RapidAPI status data.
     */
    @Test
    void getRapidApiStatus() {
        when(rapidApiHelper.getRapidApiStatus()).thenReturn("Status Data");
        Object result = rapidApiService.getRapidApiStatus();
        assertEquals("Status Data", result);
    }

    /**
     * Test case for successful retrieval of forecast summary data for a location.
     */
    @Test
    void getRapidApiForecastSummaryByLocationName() {
        when(rapidApiHelper.getRapidApiForecastSummaryByLocationName(anyString())).thenReturn("Forecast Summary Data");
        Object result = rapidApiService.getRapidApiForecastSummaryByLocationName("Location");
        assertEquals("Forecast Summary Data", result);
    }

    /**
     * Test case for successful retrieval of hourly forecast data for a location.
     */
    @Test
    void getRapidApiHourlyForecastByLocationName() {
        when(rapidApiHelper.getRapidApiHourlyForecastByLocationName(anyString())).thenReturn("Hourly Forecast Data");
        Object result = rapidApiService.getRapidApiHourlyForecastByLocationName("Location");
        assertEquals("Hourly Forecast Data", result);
    }
}
