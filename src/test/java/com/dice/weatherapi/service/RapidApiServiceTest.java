package com.dice.weatherapi.service;

import com.dice.weatherapi.exception.RapidApiHelperException;
import com.dice.weatherapi.helper.utility.RapidApiHelper;
import com.dice.weatherapi.service.serviceImpl.RapidApiServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the RapidApiService interface.
 */
class RapidApiServiceTest {

    @Mock
    private RapidApiHelper rapidApiHelper;

    @InjectMocks
    private RapidApiService rapidApiService = new RapidApiServiceImplementation(rapidApiHelper);

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
    void getRapidApiIndex_Success() {
        when(rapidApiHelper.getRapidApiIndex()).thenReturn("Index Data");
        Object result = rapidApiService.getRapidApiIndex();
        assertEquals("Index Data", result);
    }

    /**
     * Test case for handling an exception during retrieval of RapidAPI index data.
     */
    @Test
    void getRapidApiIndex_Exception() {
        when(rapidApiHelper.getRapidApiIndex()).thenThrow(new RapidApiHelperException("Error"));
        assertThrows(RapidApiHelperException.class, () -> rapidApiService.getRapidApiIndex());
    }

    /**
     * Test case for successful retrieval of RapidAPI status data.
     */
    @Test
    void getRapidApiStatus_Success() {
        when(rapidApiHelper.getRapidApiStatus()).thenReturn("Status Data");
        Object result = rapidApiService.getRapidApiStatus();
        assertEquals("Status Data", result);
    }

    /**
     * Test case for handling an exception during retrieval of RapidAPI status data.
     */
    @Test
    void getRapidApiStatus_Exception() {
        when(rapidApiHelper.getRapidApiStatus()).thenThrow(new RapidApiHelperException("Error"));
        assertThrows(RapidApiHelperException.class, () -> rapidApiService.getRapidApiStatus());
    }

    /**
     * Test case for successful retrieval of forecast summary data for a location.
     */
    @Test
    void getRapidApiForecastSummaryByLocationName_Success() {
        when(rapidApiHelper.getRapidApiForecastSummaryByLocationName(anyString())).thenReturn("Forecast Summary Data");
        Object result = rapidApiService.getRapidApiForecastSummaryByLocationName("Location");
        assertEquals("Forecast Summary Data", result);
    }

    /**
     * Test case for handling an exception during retrieval of forecast summary data for a location.
     */
    @Test
    void getRapidApiForecastSummaryByLocationName_Exception() {
        when(rapidApiHelper.getRapidApiForecastSummaryByLocationName(anyString())).thenThrow(new RapidApiHelperException("Error"));
        assertThrows(RapidApiHelperException.class, () -> rapidApiService.getRapidApiForecastSummaryByLocationName("Location"));
    }

    /**
     * Test case for successful retrieval of hourly forecast data for a location.
     */
    @Test
    void getRapidApiHourlyForecastByLocationName_Success() {
        when(rapidApiHelper.getRapidApiHourlyForecastByLocationName(anyString())).thenReturn("Hourly Forecast Data");
        Object result = rapidApiService.getRapidApiHourlyForecastByLocationName("Location");
        assertEquals("Hourly Forecast Data", result);
    }

    /**
     * Test case for handling an exception during retrieval of hourly forecast data for a location.
     */
    @Test
    void getRapidApiHourlyForecastByLocationName_Exception() {
        when(rapidApiHelper.getRapidApiHourlyForecastByLocationName(anyString())).thenThrow(new RapidApiHelperException("Error"));
        assertThrows(RapidApiHelperException.class, () -> rapidApiService.getRapidApiHourlyForecastByLocationName("Location"));
    }
}

