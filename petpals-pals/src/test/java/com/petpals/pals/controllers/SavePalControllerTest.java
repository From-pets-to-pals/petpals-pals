package com.petpals.pals.controllers;

import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
public class SavePalControllerTest {
    @Test
    void openApi(@Client("/") HttpClient httpClient)  {
        BlockingHttpClient client = httpClient.toBlocking();
            HttpRequest<?> request =
                    HttpRequest.GET("/pals/Ashe").header(
                            "API-KEY", "pals-0.1.0");
            assertEquals("Hello world, and ".concat("Ashe"),client.retrieve(request));
        
        
    }
    
    @Test
    void shouldFailWhenNotProvidingApiKey(@Client("/") HttpClient httpClient)  {
        BlockingHttpClient client = httpClient.toBlocking();
        HttpRequest<?> request =
                HttpRequest.GET("/pals/Ashe");
        assertThrows(HttpClientResponseException.class, () -> client.retrieve(request));
        
    }
}
