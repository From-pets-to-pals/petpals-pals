package com.petpals.application.entrypoints

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement

@Path("/hello")
@SecurityRequirement(name = "api_key")
class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from Quarkus REST"
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    fun bye() = "Hello from Quarkus REST"
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    fun put() = "Hello from Quarkus REST"
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    fun del() = "Hello from Quarkus REST"
}