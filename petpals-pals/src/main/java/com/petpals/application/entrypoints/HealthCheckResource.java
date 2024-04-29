package com.petpals.application.entrypoints;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

@Path("/hello")
@SecurityRequirement(name = "api_key")
public class HealthCheckResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello()
    {
        return "Hello from pals";
    }
}