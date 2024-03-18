package com.petpals.pals.controllers;

import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class SavePalControllerTest {
    @Test
    void openApi(@Client("/") HttpClient httpClient) {
        BlockingHttpClient client = httpClient.toBlocking();
        var palName = "Ash";
        var response = client.retrieve("/pals/".concat(palName));
        assertEquals("Hello world, and ".concat(palName),response);
    }
}
