package com.petpals.application.entrypoints;

import com.petpals.shared.model.Breed;
import com.petpals.shared.model.Country;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import java.util.List;

@Path("/options")
@SecurityRequirement(name = "api_key")
public class MenuOptionsResource {
	@GET
	@Path("/countries")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries() {
		return null;
	}
	
	@GET
	@Path("/breeds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Breed> getBreeds() {
		return null;
	}
}
