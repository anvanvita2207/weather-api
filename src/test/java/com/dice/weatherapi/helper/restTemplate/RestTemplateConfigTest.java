package com.dice.weatherapi.helper.restTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for RestTemplateConfig.
 */
class RestTemplateConfigTest {

    /**
     * Test for creating RestTemplate bean with configured interceptors.
     */
    @Test
    public void testRestTemplateCreation() {
        RestTemplateConfig restTemplateConfig = new RestTemplateConfig();
        RestTemplate restTemplate = restTemplateConfig.restTemplate();

        assertEquals(1, restTemplate.getInterceptors().size());
    }

    /**
     * Test for defining custom headers for interacting with RapidAPI.
     */
    @Test
    public void testRapidApiHeaders() {
        RestTemplateConfig restTemplateConfig = new RestTemplateConfig();
        HttpHeaders headers = restTemplateConfig.rapidApiHeaders();

        assertEquals("TestApiKey", headers.getFirst("X-RapidAPI-Key"));
        assertEquals("TestHost", headers.getFirst("X-RapidAPI-Host"));
    }
}

