package com.petpals.bootstrap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petpals.shared.errorhandling.PetPalsExceptions;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper
import org.jboss.logging.Logger;


class ExceptionHandler : ExceptionMapper<PetPalsExceptions> {
    override fun toResponse(e: PetPalsExceptions): Response {
        val objectMapper = ObjectMapper()
        return try {
            Logger.getLogger("here").info(objectMapper.writeValueAsString(e))
            Response.status(Response.Status.fromStatusCode(e.appError.httpResponseStatus))
                    .entity(objectMapper.writeValueAsString(e.appError))
                    .build()
        } catch (ex: JsonProcessingException) {
            Response.status(Response.Status.fromStatusCode(e.appError.httpResponseStatus))
                    .entity(e.appError.message)
                    .build()
        }
    }
}