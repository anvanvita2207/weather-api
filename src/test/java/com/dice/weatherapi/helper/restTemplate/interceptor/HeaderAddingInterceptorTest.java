package com.dice.weatherapi.helper.restTemplate.interceptor;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test class for HeaderAddingInterceptor.
 */
class HeaderAddingInterceptorTest {

    /**
     * Test for intercepting HTTP request and adding headers.
     * @throws IOException if an I/O error occurs
     */
    @Test
    public void testIntercept() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Custom-Header", "TestValue");
        HeaderAddingInterceptor interceptor = new HeaderAddingInterceptor(headers);

        HttpRequest request = mock(HttpRequest.class);
        ClientHttpRequestExecution execution = mock(ClientHttpRequestExecution.class);
        ClientHttpResponse response = mock(ClientHttpResponse.class);

        when(execution.execute(request, new byte[0])).thenReturn(response);

        ClientHttpResponse result = interceptor.intercept(request, new byte[0], execution);

        assertEquals(response, result);
        verify(request).getHeaders();
        verify(request.getHeaders()).addAll("X-Custom-Header", headers.get("X-Custom-Header"));
    }
}

