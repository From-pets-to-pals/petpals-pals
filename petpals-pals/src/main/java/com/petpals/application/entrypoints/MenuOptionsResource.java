package com.petpals.application.entrypoints;

import com.petpals.application.mappers.BreedsMapper;
import com.petpals.application.mappers.CountriesMapper;
import com.petpals.application.mappers.SpeciesMapper;
import com.petpals.persistence.ports.in.MenuOptionsIn;
import com.petpals.shared.model.Breed;
import com.petpals.shared.model.BreedWithoutSpecie;
import com.petpals.shared.model.Country;
import com.petpals.shared.model.Specie;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import java.util.List;

@Path("/options")
@SecurityRequirement(name = "api_key")
public class MenuOptionsResource {
	MenuOptionsIn menuOptionsIn;
	
	CountriesMapper countriesMapper;
	
	BreedsMapper breedsMapper;
	
	SpeciesMapper speciesMapper;
	
	public MenuOptionsResource(MenuOptionsIn menuOptionsIn, CountriesMapper countriesMapper, BreedsMapper breedsMapper, SpeciesMapper speciesMapper) {
		this.menuOptionsIn = menuOptionsIn;
		this.countriesMapper = countriesMapper;
		this.breedsMapper = breedsMapper;
		this.speciesMapper = speciesMapper;
	}
	
	@GET
	@Path("/countries")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries() {
		return countriesMapper.fromEntities(menuOptionsIn.getCountries());
	}
	
	@GET
	@Path("/breeds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Breed> getBreeds() {
		return breedsMapper.fromEntities(menuOptionsIn.getBreeds());
	}
	
	@GET
	@Path("/breeds/dogs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BreedWithoutSpecie> getDogBreeds() {
		return breedsMapper.fromDogBreedEntities(menuOptionsIn.getDogBreeds());
	}
	
	@GET
	@Path("/breeds/cats")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BreedWithoutSpecie> getCatBreeds() {
		return breedsMapper.fromCatBreedEntities(menuOptionsIn.getCatBreeds());
	}
	
	@GET
	@Path("/breeds/nacs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BreedWithoutSpecie> getNacBreeds() {
		return breedsMapper.fromNacBreedEntities(menuOptionsIn.getNacBreeds());
	}
	
	@GET
	@Path("/species")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Specie> getSpecies() {
		return speciesMapper.fromEntities(menuOptionsIn.getSpecies());
	}
}
