package com.petpals.application.entrypoints;

import com.petpals.application.dto.AddFirstPal;
import com.petpals.application.dto.NewOwner;
import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.entities.Pals;
import com.petpals.persistence.ports.in.CreateOwnerIn;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.jboss.logging.Logger;

import java.sql.Date;
import java.util.ArrayList;

@Path("/pals")
@SecurityRequirement(name = "api_key")
public class CreateOwnerResource {
	private static final Logger LOGGER = Logger.getLogger(CreateOwnerResource.class);
	
	private CreateOwnerIn createOwnerIn;
	
	public CreateOwnerResource(CreateOwnerIn createOwnerIn) {
		this.createOwnerIn = createOwnerIn;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void createOwner(@Valid NewOwner newOwner) {
		
		LOGGER.info("Calling createFirstPalWithOwner");
		LOGGER.info("Received new payload for newPal :$newPal");
		var owner = new Owners(
				newOwner.email(),
				newOwner.deviceId(),
				newOwner.reference(),
				newOwner.location()
		);
		var palToRegister = new ArrayList<Pals>();
		for(AddFirstPal pal : newOwner.pals()){
			palToRegister.add(
				new Pals(
						pal.name(),
						pal.shortName(),
						pal.icadIdentifier(),
						owner,
						new Date(pal.birthDate().getTime()),
						pal.specie().name(),
						pal.breed(),
						pal.hasPassport(),
						pal.isMale(),
						pal.isSterilized(),
						pal.isVaccinated(),
						null,
						null,
						pal.reference()
				)
				
			);
			owner.setPalsList(palToRegister);
		}
		createOwnerIn.createOwnerWithFirstPal(owner);// (3)
	}
}