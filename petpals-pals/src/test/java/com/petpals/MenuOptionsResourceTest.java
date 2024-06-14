package com.petpals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petpals.persistence.entities.*;
import com.petpals.persistence.ports.in.MenuOptionsIn;
import com.petpals.shared.model.dto.Breed;
import com.petpals.shared.model.dto.BreedWithoutSpecie;
import com.petpals.shared.model.dto.Country;
import com.petpals.shared.model.dto.Specie;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class MenuOptionsResourceTest {
	
	@InjectMock
	private MenuOptionsIn menuOptionsIn;
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	void testGetCountriesEndpoint() throws JsonProcessingException {
		var france = new Countries();
		france.setId((short) 1);
		france.setName("France");
		france.setCode("FR");
		france.setNumber("250");
		Mockito.when(menuOptionsIn.getCountries()).thenReturn(List.of(france));
		var toReturn  = new Country("FR","France","250");
		var json = mapper.writeValueAsString(List.of(toReturn));
		given()
				.headers("API-KEY","pals-0.1.0")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.when().get("/options/countries")
				.then()
				.statusCode(200)
				.body(is(json));
	}
	
	@Test
	void testGetSpeciesEndpoint() throws JsonProcessingException {
		var dogs = new Species();
		dogs.setId((short) 1);
		dogs.setName("DOG");
		Mockito.when(menuOptionsIn.getSpecies()).thenReturn(List.of(dogs));
		var toReturn  = new Specie("DOG");
		var json = mapper.writeValueAsString(List.of(toReturn));
		given()
				.headers("API-KEY","pals-0.1.0")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.when().get("/options/species")
				.then()
				.statusCode(200)
				.body(is(json));
		
	}
	
	@Test
	void testGetBreedsEndpoint() throws JsonProcessingException {
		var dogSpecies = new Species();
		dogSpecies.setId((short) 1);
		dogSpecies.setName("DOG");
		var dogBreed = new Breeds();
		dogBreed.setId((short) 1);
		dogBreed.setName("Husky");
		dogBreed.setSpecie(dogSpecies);
		Mockito.when(menuOptionsIn.getBreeds()).thenReturn(List.of(dogBreed));
		var specieToReturn  = new Specie("DOG");
		var breedToReturn = new Breed("Husky", specieToReturn);
		var json = mapper.writeValueAsString(List.of(breedToReturn));
		given()
				.headers("API-KEY","pals-0.1.0")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.when().get("/options/breeds")
				.then()
				.statusCode(200)
				.body(is(json));
		
	}
	
	@Test
	void testGetDogBreedsEndpoint() throws JsonProcessingException {
		var dogSpecies = new Species();
		dogSpecies.setId((short) 1);
		dogSpecies.setName("DOG");
		var dogBreed = new DogBreeds();
		dogBreed.setId((short) 1);
		dogBreed.setName("Husky");
		dogBreed.setSpecie(dogSpecies);
		Mockito.when(menuOptionsIn.getDogBreeds()).thenReturn(List.of(dogBreed));
		var breedToReturn = new BreedWithoutSpecie("Husky");
		var json = mapper.writeValueAsString(List.of(breedToReturn));
		given()
				.headers("API-KEY","pals-0.1.0")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.when().get("/options/breeds/dogs")
				.then()
				.statusCode(200)
				.body(is(json));
		
	}
	
	@Test
	void testGetCatBreedsEndpoint() throws JsonProcessingException {
		var catSpecies = new Species();
		catSpecies.setId((short) 1);
		catSpecies.setName("CAT");
		var catBreed = new CatBreeds();
		catBreed.setId((short) 1);
		catBreed.setName("Birman");
		catBreed.setSpecie(catSpecies);
		Mockito.when(menuOptionsIn.getCatBreeds()).thenReturn(List.of(catBreed));
		var breedToReturn = new BreedWithoutSpecie("Birman");
		var json = mapper.writeValueAsString(List.of(breedToReturn));
		given()
				.headers("API-KEY","pals-0.1.0")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.when().get("/options/breeds/cats")
				.then()
				.statusCode(200)
				.body(is(json));
	}
	
	@Test
	void testGetNacBreedsEndpoint() throws JsonProcessingException {
		Mockito.when(menuOptionsIn.getNacBreeds()).thenReturn(new ArrayList<>());
		var json = mapper.writeValueAsString(new ArrayList<>());
		given()
				.headers("API-KEY","pals-0.1.0")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.when().get("/options/breeds/cats")
				.then()
				.statusCode(200)
				.body(is(json));
	}
}
