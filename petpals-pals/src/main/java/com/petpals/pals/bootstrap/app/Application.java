package com.petpals.pals.bootstrap.app;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@OpenAPIDefinition(
        info = @Info(
                title = "petpals-pals",
                version = "0.1.0",
                description = "Petpals app for handling pals",
                license = @License(name = "Apache 2.0", url = "https://foo.bar"),
                contact = @Contact(name = "Sid", email = "sa.bennaceur@gmail.com")
        )
)
@SecurityScheme(
        name = "api_key",
        type = SecuritySchemeType.APIKEY,
        paramName = "API-KEY",
        in = SecuritySchemeIn.HEADER
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}