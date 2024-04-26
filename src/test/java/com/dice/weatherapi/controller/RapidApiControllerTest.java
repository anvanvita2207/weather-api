package com.dice.weatherapi.controller;

import com.dice.weatherapi.exception.RapidApiHelperException;
import com.dice.weatherapi.service.RapidApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test class for RapidApiController.
 */
public class RapidApiControllerTest {

    @Mock
    private RapidApiService rapidApiService;

    @InjectMocks
    private RapidApiController rapidApiController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test for successful retrieval of RapidAPI index.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testGetRapidApiIndex() throws Exception {
        Object mockIndexData = new Object();
        when(rapidApiService.getRapidApiIndex()).thenReturn(mockIndexData);
        ResponseEntity<Object> response = rapidApiController.getRapidApiIndex();
        verify(rapidApiService, times(1)).getRapidApiIndex();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockIndexData, response.getBody());
    }

    /**
     * Test for handling exception while retrieving RapidAPI index.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testGetRapidApiIndex_Exception() throws Exception {
        when(rapidApiService.getRapidApiIndex()).thenThrow(new RapidApiHelperException("Error"));
        ResponseEntity<Object> response = rapidApiController.getRapidApiIndex();
        verify(rapidApiService, times(1)).getRapidApiIndex();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error occurred while fetching RapidAPI index", response.getBody());
    }

    /**
     * Test for successful retrieval of RapidAPI status.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testGetRapidApiStatus() throws Exception {
        Object mockStatusData = new Object();
        when(rapidApiService.getRapidApiStatus()).thenReturn(mockStatusData);
        ResponseEntity<Object> response = rapidApiController.getRapidApiStatus();
        verify(rapidApiService, times(1)).getRapidApiStatus();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockStatusData, response.getBody());
    }

    /**
     * Test for handling exception while retrieving RapidAPI status.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testGetRapidApiStatus_Exception() throws Exception {
        when(rapidApiService.getRapidApiStatus()).thenThrow(new RapidApiHelperException("Error"));
        ResponseEntity<Object> response = rapidApiController.getRapidApiStatus();
        verify(rapidApiService, times(1)).getRapidApiStatus();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error occurred while fetching RapidAPI status", response.getBody());
    }

    /**
     * Test for successful retrieval of forecast summary by location name.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testGetForecastSummaryByLocationName() throws Exception {
        String location = "New York";
        Object mockSummaryData = new Object();
        when(rapidApiService.getRapidApiForecastSummaryByLocationName(location)).thenReturn(mockSummaryData);
        ResponseEntity<Object> response = rapidApiController.getForecastSummaryByLocationName(location);
        verify(rapidApiService, times(1)).getRapidApiForecastSummaryByLocationName(location);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockSummaryData, response.getBody());
    }

    /**
     * Test for handling exception while retrieving forecast summary by location name.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testGetForecastSummaryByLocationName_Exception() throws Exception {
        String location = "New York";
        when(rapidApiService.getRapidApiForecastSummaryByLocationName(location)).thenThrow(new RapidApiHelperException("Error"));
        ResponseEntity<Object> response = rapidApiController.getForecastSummaryByLocationName(location);
        verify(rapidApiService, times(1)).getRapidApiForecastSummaryByLocationName(location);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error occurred while fetching forecast summary for location New York", response.getBody());
    }

    /**
     * Test for successful retrieval of hourly forecast by location name.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testGetHourlyForecastByLocationName() throws Exception {
        String location = "New York";
        Object mockHourlyData = new Object();
        when(rapidApiService.getRapidApiHourlyForecastByLocationName(location)).thenReturn(mockHourlyData);
        ResponseEntity<Object> response = rapidApiController.getHourlyForecastByLocationName(location);
        verify(rapidApiService, times(1)).getRapidApiHourlyForecastByLocationName(location);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockHourlyData, response.getBody());
    }

    /**
     * Test for handling exception while retrieving hourly forecast by location name.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testGetHourlyForecastByLocationName_Exception() throws Exception {
        String location = "New York";
        when(rapidApiService.getRapidApiHourlyForecastByLocationName(location)).thenThrow(new RapidApiHelperException("Error"));
        ResponseEntity<Object> response = rapidApiController.getHourlyForecastByLocationName(location);
        verify(rapidApiService, times(1)).getRapidApiHourlyForecastByLocationName(location);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error occurred while fetching hourly forecast for location New York", response.getBody());
    }
}
