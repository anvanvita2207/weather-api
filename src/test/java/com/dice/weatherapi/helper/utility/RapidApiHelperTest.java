package com.dice.weatherapi.helper.utility;

import com.dice.weatherapi.exception.RapidApiHelperException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Test class for RapidApiHelper.
 */
public class RapidApiHelperTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RapidApiHelper rapidApiHelper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test for retrieving RapidAPI index successfully.
     */
    @Test
    public void testGetRapidApiIndex_Success() {
        when(restTemplate.getForObject("https://api.rapidapi.com/index", Object.class)).thenReturn(new Object());
        Object result = rapidApiHelper.getRapidApiIndex();
        verify(restTemplate, times(1)).getForObject("https://api.rapidapi.com/index", Object.class);
    }

    /**
     * Test for handling exception while retrieving RapidAPI index.
     */
    @Test
    public void testGetRapidApiIndex_Exception() {
        when(restTemplate.getForObject("https://api.rapidapi.com/index", Object.class)).thenThrow(new RuntimeException());
        assertThrows(RapidApiHelperException.class, () -> rapidApiHelper.getRapidApiIndex());
        verify(restTemplate, times(1)).getForObject("https://api.rapidapi.com/index", Object.class);
    }

    /**
     * Test for retrieving RapidAPI status successfully.
     */
    @Test
    public void testGetRapidApiStatus_Success() {
        when(restTemplate.getForObject("https://api.rapidapi.com/status", Object.class)).thenReturn(new Object());
        Object result = rapidApiHelper.getRapidApiStatus();
        verify(restTemplate, times(1)).getForObject("https://api.rapidapi.com/status", Object.class);
    }

    /**
     * Test for handling exception while retrieving RapidAPI status.
     */
    @Test
    public void testGetRapidApiStatus_Exception() {
        when(restTemplate.getForObject("https://api.rapidapi.com/status", Object.class)).thenThrow(new RuntimeException());
        assertThrows(RapidApiHelperException.class, () -> rapidApiHelper.getRapidApiStatus());
        verify(restTemplate, times(1)).getForObject("https://api.rapidapi.com/status", Object.class);
    }

    /**
     * Test for retrieving forecast summary by location name successfully.
     */
    @Test
    public void testGetRapidApiForecastSummaryByLocationName_Success() {
        when(restTemplate.getForObject("https://api.rapidapi.com/forecast/summary/New York", Object.class)).thenReturn(new Object());
        Object result = rapidApiHelper.getRapidApiForecastSummaryByLocationName("New York");
        verify(restTemplate, times(1)).getForObject("https://api.rapidapi.com/forecast/summary/New York", Object.class);
    }

    /**
     * Test for handling exception while retrieving forecast summary by location name.
     */
    @Test
    public void testGetRapidApiForecastSummaryByLocationName_Exception() {
        when(restTemplate.getForObject("https://api.rapidapi.com/forecast/summary/New York", Object.class)).thenThrow(new RuntimeException());
        assertThrows(RapidApiHelperException.class, () -> rapidApiHelper.getRapidApiForecastSummaryByLocationName("New York"));
        verify(restTemplate, times(1)).getForObject("https://api.rapidapi.com/forecast/summary/New York", Object.class);
    }

    /**
     * Test for retrieving hourly forecast by location name successfully.
     */
    @Test
    public void testGetRapidApiHourlyForecastByLocationName_Success() {
        when(restTemplate.getForObject("https://api.rapidapi.com/forecast/hourly/New York", Object.class)).thenReturn(new Object());
        Object result = rapidApiHelper.getRapidApiHourlyForecastByLocationName("New York");
        verify(restTemplate, times(1)).getForObject("https://api.rapidapi.com/forecast/hourly/New York", Object.class);
    }

    /**
     * Test for handling exception while retrieving hourly forecast by location name.
     */
    @Test
    public void testGetRapidApiHourlyForecastByLocationName_Exception() {
        when(restTemplate.getForObject("https://api.rapidapi.com/forecast/hourly/New York", Object.class)).thenThrow(new RuntimeException());
        assertThrows(RapidApiHelperException.class, () -> rapidApiHelper.getRapidApiHourlyForecastByLocationName("New York"));
        verify(restTemplate, times(1)).getForObject("https://api.rapidapi.com/forecast/hourly/New York", Object.class);
    }
}

