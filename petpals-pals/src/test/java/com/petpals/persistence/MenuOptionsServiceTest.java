package com.petpals.persistence;

import com.petpals.persistence.entities.*;
import com.petpals.persistence.ports.in.MenuOptionsIn;
import com.petpals.persistence.repositories.*;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
class MenuOptionsServiceTest {
	
	@InjectMock
	private BreedsRepository breedsRepository;
	@InjectMock
	private CountriesRepository countriesRepository;
	@InjectMock
	private SpeciesRepository speciesRepository;
	@Inject
	MenuOptionsIn menuOptionsIn;
	
	@Test
	void shouldRetrieveDogBreeds(){
		var doggoA = new Breeds();
		doggoA.setId((short) 1);
		doggoA.setName("Husky de Sibérie");
		var doggoB = new Breeds();
		doggoB.setId((short) 2);
		doggoB.setName("Pinscher")	;
		List<Breeds> dogBreeds = List.of(doggoA, doggoB);
		Mockito.when(breedsRepository.getAllDogBreeds()).thenReturn(dogBreeds);
		var fromRepository  = menuOptionsIn.getDogBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(doggoA.getName(), dogBreeds.get(0).getName());
		Assertions.assertEquals(doggoA.getId(), dogBreeds.get(0).getId());
		Mockito.verify(breedsRepository).getAllDogBreeds();
		Mockito.verifyNoMoreInteractions(breedsRepository);
	}
	
	@Test
	void shouldRetrieveCatBreeds(){
		var catA = new Breeds();
		catA.setName("Sacré de Birmanie");
		var catB = new Breeds();
		catB.setName("Bleu russe")	;
		List<Breeds> catBreeds = List.of(catA, catB);
		Mockito.when(breedsRepository.getAllCatBreeds()).thenReturn(catBreeds);
		var fromRepository  = menuOptionsIn.getCatBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(catA.getName(), catBreeds.get(0).getName());
		Mockito.verify(breedsRepository).getAllCatBreeds();
		Mockito.verifyNoMoreInteractions(breedsRepository);
	}
	
	
	@Test
	void shouldRetrieveNacBreeds(){
		List<Breeds> nacBreeds = new ArrayList<>();
		Mockito.when(breedsRepository.getAllNacBreeds()).thenReturn(nacBreeds);
		var fromRepository  = menuOptionsIn.getNacBreeds();
		Assertions.assertEquals(0, fromRepository.size());
		Mockito.verify(breedsRepository).getAllNacBreeds();
		Mockito.verifyNoMoreInteractions(breedsRepository);
	}
	
	@Test
	void shouldRetrieveSpecies(){
		var catSpecies = new Species();
		catSpecies.setId((short) 2);
		catSpecies.setName("CAT");
		var dogSpecies = new Species();
		dogSpecies.setId((short) 1);
		dogSpecies.setName("DOG");
		List<Species> species = List.of(dogSpecies, catSpecies);
		Mockito.when(speciesRepository.getAllSpecies()).thenReturn(species);
		var fromRepository  = menuOptionsIn.getSpecies();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(dogSpecies.getId(), fromRepository.get(0).getId());
		Assertions.assertEquals(dogSpecies.getName(), fromRepository.get(0).getName());
		Assertions.assertEquals(catSpecies.getId(), fromRepository.get(1).getId());
		Assertions.assertEquals(catSpecies.getName(), fromRepository.get(1).getName());
		Assertions.assertEquals(catSpecies, fromRepository.get(1));
		Mockito.verify(speciesRepository).getAllSpecies();
		Mockito.verifyNoMoreInteractions(speciesRepository);
	}
	@Test
	void shouldRetrieveCountries(){
		var france = new Countries();
		france.setId((short) 1);
		france.setName("France");
		france.setCode("FR");
		france.setNumber("250");
		List<Countries> countries = List.of(france);
		Mockito.when(countriesRepository.getAllCountries()).thenReturn(countries);
		var fromRepository  = menuOptionsIn.getCountries();
		Assertions.assertEquals(1, fromRepository.size());
		Assertions.assertEquals(france.getId(), fromRepository.get(0).getId());
		Assertions.assertEquals(france.getName(), fromRepository.get(0).getName());
		Assertions.assertEquals(france.getCode(), fromRepository.get(0).getCode());
		Assertions.assertEquals(france.getNumber(), fromRepository.get(0).getNumber());
		Mockito.verify(countriesRepository).getAllCountries();
		Mockito.verifyNoMoreInteractions(countriesRepository);
	}
	@Test
	void shouldRetrieveBreeds(){
		var dogBreed = new Breeds();
		dogBreed.setId((short) 1);
		dogBreed.setName("Husky");
		var catBreed = new Breeds();
		catBreed.setId((short)2);
		catBreed.setName("Sacré de birmanie");
		List<Breeds> breeds = List.of(dogBreed, catBreed);
		Mockito.when(breedsRepository.getAllBreeds()).thenReturn(breeds);
		var fromRepository  = menuOptionsIn.getBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(dogBreed.getName(), fromRepository.get(0).getName());
		Assertions.assertEquals(dogBreed.getId(), fromRepository.get(0).getId());
		Assertions.assertEquals(catBreed, fromRepository.get(1));
		Assertions.assertEquals(catBreed.getName(), fromRepository.get(1).getName());
		Assertions.assertEquals(catBreed.getId(), fromRepository.get(1).getId());
		Mockito.verify(breedsRepository).getAllBreeds();
		Mockito.verifyNoMoreInteractions(speciesRepository);
	}
}
