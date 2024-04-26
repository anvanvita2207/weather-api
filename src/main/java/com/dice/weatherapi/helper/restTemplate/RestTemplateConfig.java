package com.dice.weatherapi.helper.restTemplate;

import com.dice.weatherapi.helper.restTemplate.interceptor.HeaderAddingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration class for creating a RestTemplate bean.
 */
@Configuration
public class RestTemplateConfig {

    @Value("${rapid.api.apiKey}")
    private String apiKey;

    @Value("${rapid.api.host}")
    private String rapidApiHost;

    /**
     * Creates a RestTemplate bean with configured interceptors.
     * @return RestTemplate instance.
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(getInterceptors());
        return restTemplate;
    }

    /**
     * Defines custom headers for interacting with RapidAPI.
     * @return HttpHeaders instance containing the necessary headers.
     */
    @Bean
    public HttpHeaders rapidApiHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", rapidApiHost);
        return headers;
    }

    /**
     * Configures interceptors to add custom headers to RestTemplate requests.
     * @return List of interceptors.
     */
    private List<ClientHttpRequestInterceptor> getInterceptors() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderAddingInterceptor(rapidApiHeaders()));
        return interceptors;
    }
}
