package com.petpals.application.entrypoints;

import com.petpals.application.dto.NewOwnerRequest;
import com.petpals.application.mappers.NewOwnerRequestMapper;
import com.petpals.persistence.ports.in.CreateOwnerIn;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.jboss.logging.Logger;

import java.text.ParseException;


@Path("/owners")
@SecurityRequirement(name = "api_key")
public class CreateOwnerResource {
	private static final Logger LOGGER = Logger.getLogger(CreateOwnerResource.class);
	
	private final CreateOwnerIn createOwnerIn;
	private final NewOwnerRequestMapper newOwnerRequestMapper;
	
	public CreateOwnerResource(CreateOwnerIn createOwnerIn, NewOwnerRequestMapper newOwnerRequestMapper) {
		this.createOwnerIn = createOwnerIn;
		this.newOwnerRequestMapper = newOwnerRequestMapper;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Long createOwner(@Valid NewOwnerRequest newOwnerRequest) throws ParseException {
		LOGGER.info("Calling createFirstPalWithOwner");
		LOGGER.info("Received new payload for newPal : $newPal");
		return createOwnerIn.createOwnerWithFirstPal(newOwnerRequestMapper.toEntity(newOwnerRequest));// (3)
	}
}