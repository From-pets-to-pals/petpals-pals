package com.petpals.bootstrap

import io.quarkus.qute.Template
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class NotFoundExceptionMapper : ExceptionMapper<NotFoundException?> {
    @Inject
    @field:Default
    lateinit var error404: Template;

    override fun toResponse(exception: NotFoundException?): Response {
        return Response.ok(error404.render(), MediaType.TEXT_HTML).build()
    }
}