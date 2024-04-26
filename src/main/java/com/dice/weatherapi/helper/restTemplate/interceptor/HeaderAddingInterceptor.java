package com.dice.weatherapi.helper.restTemplate.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import java.io.IOException;

/**
 * Interceptor class to add custom headers to outgoing HTTP requests.
 */
public class HeaderAddingInterceptor implements ClientHttpRequestInterceptor {

    private final HttpHeaders headersToAdd;

    /**
     * Constructs a HeaderAddingInterceptor with the specified HttpHeaders.
     * @param headersToAdd HttpHeaders instance containing the headers to be added.
     */
    public HeaderAddingInterceptor(HttpHeaders headersToAdd) {
        this.headersToAdd = headersToAdd;
    }

    /**
     * Intercepts the outgoing HTTP request and adds custom headers.
     * @param request the outgoing HTTP request
     * @param body the request body, if any
     * @param execution the request execution
     * @return the HTTP response
     * @throws IOException in case of I/O errors
     */
    @Override
    public ClientHttpResponse intercept(org.springframework.http.HttpRequest request, byte[] body,
                                        org.springframework.http.client.ClientHttpRequestExecution execution)
                                        throws IOException {
        headersToAdd.forEach((key, values) -> request.getHeaders().addAll(key, values));
        return execution.execute(request, body);
    }
}
