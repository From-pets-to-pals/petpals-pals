package com.petpals.application.entrypoints;

import com.petpals.application.dto.AuthOwnerRequest;
import com.petpals.application.mappers.AuthOwnerRequestMapper;
import com.petpals.persistence.ports.in.AuthOwnerIn;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.jboss.logging.Logger;

import java.text.ParseException;


@Path("/owners/auth")
@SecurityRequirement(name = "api_key")
public class AuthOwnerResource {
    private static final Logger LOGGER = Logger.getLogger(CreateOwnerResource.class);

    private final AuthOwnerIn authOwnerIn;
    private final AuthOwnerRequestMapper authOwnerRequestMapper;

    public AuthOwnerResource(AuthOwnerIn authOwnerIn, AuthOwnerRequestMapper authOwnerRequestMapper) {
        this.authOwnerIn = authOwnerIn;
        this.authOwnerRequestMapper = authOwnerRequestMapper;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String authOwner(@Valid AuthOwnerRequest authOwnerRequest) throws ParseException {
        LOGGER.info("Calling authOwner");
        return authOwnerIn.authOwner(authOwnerRequestMapper.toEntity(authOwnerRequest)); //TODO vérifier l'archi
    }
}