package com.petpals.application.entrypoints;

import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.ports.in.ProfileIn;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;


@Path("/profile")
@SecurityRequirement(name = "api_key")
public class OwnerProfileResource {
	
	private final ProfileIn profileIn;
	
	public OwnerProfileResource(ProfileIn profileIn) {
		this.profileIn = profileIn;
	}
	
	@GET
	@Path("/profile/{reference}")
	@Produces(MediaType.APPLICATION_JSON)
	public Owners getProfileWithPals(@PathParam("reference") String reference) {
		return profileIn.getOwnersWithPals(reference);
	}

}
