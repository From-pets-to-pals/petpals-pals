package com.petpals.application.entrypoints;

import com.petpals.application.dto.responses.CreateCaregiverOptions;
import com.petpals.application.dto.responses.CreateOwnerOptions;
import com.petpals.application.mappers.CreateCaregiverOptionsResponseMapper;
import com.petpals.application.mappers.CreateOwnerOptionsResponseMapper;
import com.petpals.persistence.ports.in.MenuOptionsIn;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

@Path("/options")
@SecurityRequirement(name = "api_key")
public class MenuOptionsResource {
	MenuOptionsIn menuOptionsIn;
	
	CreateCaregiverOptionsResponseMapper createCaregiverOptionsResponseMapper;
	CreateOwnerOptionsResponseMapper createOwnerOptionsResponseMapper;
	
	public MenuOptionsResource(MenuOptionsIn menuOptionsIn, CreateCaregiverOptionsResponseMapper createCaregiverOptionsResponseMapper, CreateOwnerOptionsResponseMapper createOwnerOptionsResponseMapper) {
		this.menuOptionsIn = menuOptionsIn;
		this.createCaregiverOptionsResponseMapper = createCaregiverOptionsResponseMapper;
		this.createOwnerOptionsResponseMapper = createOwnerOptionsResponseMapper;
	}
	
	@GET
	@Path("/create/caregivers")
	@Produces(MediaType.APPLICATION_JSON)
	public CreateCaregiverOptions getCountries() {
		var countries = menuOptionsIn.getCountries();
		var species = menuOptionsIn.getSpecies();
		return createCaregiverOptionsResponseMapper.toResponse(countries, species);
	}
	
	@GET
	@Path("/create/owners")
	@Produces(MediaType.APPLICATION_JSON)
	public CreateOwnerOptions getBreeds() {
		var countries = menuOptionsIn.getCountries();
		var species = menuOptionsIn.getSpecies();
		var breeds = menuOptionsIn.getBreeds();
		return createOwnerOptionsResponseMapper.toResponse(countries, species, breeds);
	}
}
