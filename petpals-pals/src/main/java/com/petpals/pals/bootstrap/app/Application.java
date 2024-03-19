package com.petpals.pals.bootstrap.app;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(
        info = @Info(
                title = "Petpals pals",
                version = "0.1",
                description = "Petpals app for handling pals",
                license = @License(name = "Apache 2.0", url = "https://foo.bar"),
                contact = @Contact(name = "Sid", email = "sa.bennaceur@gmail.com")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}