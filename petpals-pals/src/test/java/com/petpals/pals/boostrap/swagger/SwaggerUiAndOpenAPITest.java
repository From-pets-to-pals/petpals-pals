package com.petpals.pals.boostrap.swagger;

import io.micronaut.core.io.ResourceLoader;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class SwaggerUiAndOpenAPITest {

    @Test
    void buildGeneratesOpenApi(ResourceLoader resourceLoader) {
        assertTrue(resourceLoader.getResource("META-INF/templates/index.html").isPresent());
    }
    @Test
    void openApi(@Client("/") HttpClient httpClient) {
        BlockingHttpClient client = httpClient.toBlocking();
        assertDoesNotThrow(() -> client.exchange("/"));
    }
}