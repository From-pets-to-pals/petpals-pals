package com.petpals.persistence;

import com.petpals.persistence.entities.*;
import com.petpals.persistence.entities.compositekeys.BreedsPk;
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
	@InjectMock
	private DogBreedsRepository dogBreedsRepository;
	@InjectMock
	private CatBreedsRepository catBreedsRepository;
	
	@InjectMock
	private NacBreedsRepository nacBreedsRepository;
	@Inject
	MenuOptionsIn menuOptionsIn;
	
	@Test
	void shouldRetrieveDogBreeds(){
		var pk = new BreedsPk();
		pk.setId((short) 1);
		var doggoA = new DogBreeds();
		doggoA.setIdo(pk);
		doggoA.setName("Husky de Sibérie");
		var doggoB = new DogBreeds();
		var pk2 = new BreedsPk();
		pk2.setId((short) 2);
		doggoA.setIdo(pk2);
		
		doggoB.setName("Pinscher")	;
		List<DogBreeds> dogBreeds = List.of(doggoA, doggoB);
		Mockito.when(dogBreedsRepository.listAll()).thenReturn(dogBreeds);
		var fromRepository  = menuOptionsIn.getDogBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(doggoA.getName(), dogBreeds.get(0).getName());
		Assertions.assertEquals(doggoA.getKey(), dogBreeds.get(0).getKey());
		Mockito.verify(dogBreedsRepository).listAll();
		Mockito.verifyNoMoreInteractions(dogBreedsRepository);
	}
	
	@Test
	void shouldRetrieveCatBreeds(){
		var catA = new CatBreeds();
		catA.setName("Sacré de Birmanie");
		var catB = new CatBreeds();
		catB.setName("Bleu russe")	;
		List<CatBreeds> catBreeds = List.of(catA, catB);
		Mockito.when(catBreedsRepository.listAll()).thenReturn(catBreeds);
		var fromRepository  = menuOptionsIn.getCatBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(catA.getName(), catBreeds.get(0).getName());
		Mockito.verify(catBreedsRepository).listAll();
		Mockito.verifyNoMoreInteractions(catBreedsRepository);
	}
	
	
	@Test
	void shouldRetrieveNacBreeds(){
		List<NacBreeds> nacBreeds = new ArrayList<>();
		Mockito.when(nacBreedsRepository.listAll()).thenReturn(nacBreeds);
		var fromRepository  = menuOptionsIn.getNacBreeds();
		Assertions.assertEquals(0, fromRepository.size());
		Mockito.verify(nacBreedsRepository).listAll();
		Mockito.verifyNoMoreInteractions(nacBreedsRepository);
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
		var catSpecies = new Species();
		catSpecies.setId((short) 2);
		catSpecies.setName("CAT");
		var dogSpecies = new Species();
		dogSpecies.setId((short) 1);
		dogSpecies.setName("DOG");
		var dogBreed = new Breeds();
		var pk1 = new BreedsPk();
		pk1.setId((short) 1);
		pk1.setSpecie(dogSpecies);
		dogBreed.setIdo(pk1);
		dogBreed.setName("Husky");
		var catBreed = new Breeds();
		var pk2 = new BreedsPk();
		pk2.setId((short) 1);
		pk2.setSpecie(catSpecies);
		catBreed.setIdo(pk2);
		catBreed.setName("Sacré de birmanie");
		List<Breeds> breeds = List.of(dogBreed, catBreed);
		Mockito.when(breedsRepository.getAllBreeds()).thenReturn(breeds);
		var fromRepository  = menuOptionsIn.getBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(dogBreed.getKey(), fromRepository.get(0).getKey());
		Assertions.assertEquals(dogBreed.getName(), fromRepository.get(0).getName());
		Assertions.assertEquals(dogBreed.getKey().getId(), fromRepository.get(0).getKey().getId());
		Assertions.assertEquals(dogBreed.getKey().getSpecie().getName(),
								fromRepository.get(0).getKey().getSpecie().getName());
		Assertions.assertEquals(catBreed.getKey(), fromRepository.get(1).getKey());
		Assertions.assertEquals(catBreed, fromRepository.get(1));
		Assertions.assertEquals(catBreed.getName(), fromRepository.get(1).getName());
		Assertions.assertEquals(catBreed.getKey().getSpecie().getId(), fromRepository.get(1).getKey().getSpecie().getId());
		Assertions.assertEquals(catBreed.getKey().getSpecie().getName(), fromRepository.get(1).getKey().getSpecie().getName());
		Mockito.verify(breedsRepository).getAllBreeds();
		Mockito.verifyNoMoreInteractions(speciesRepository);
	}
}
