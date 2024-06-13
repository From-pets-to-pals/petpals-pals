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
	public BreedsRepository breedsRepository;
	@InjectMock
	public CountriesRepository countriesRepository;
	@InjectMock
	public SpeciesRepository speciesRepository;
	@InjectMock
	public DogBreedsRepository dogBreedsRepository;
	@InjectMock
	public CatBreedsRepository catBreedsRepository;
	
	@InjectMock
	public NacBreedsRepository nacBreedsRepository;
	@Inject
	MenuOptionsIn menuOptionsIn;
	
	@Test
	void shouldRetrieveDogBreeds(){
		var doggoA = new DogBreeds();
		doggoA.setId((short) 1);
		doggoA.setName("Husky de Sibérie");
		var doggoB = new DogBreeds();
		doggoA.setId((short) 2);
		
		doggoB.setName("Pinscher")	;
		List<DogBreeds> dogBreeds = List.of(doggoA, doggoB);
		Mockito.when(dogBreedsRepository.listAll()).thenReturn(dogBreeds);
		var fromRepository  = menuOptionsIn.getDogBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(doggoA.getName(), dogBreeds.get(0).getName());
		Assertions.assertEquals(doggoA.getId(), dogBreeds.get(0).getId());
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
	void shouldRetrieveBreeds(){
		var catSpecies = new Species();
		catSpecies.setId((short) 2);
		catSpecies.setName("CAT");
		var dogSpecies = new Species();
		dogSpecies.setId((short) 1);
		dogSpecies.setName("DOG");
		var dogBreed = new Breeds();
		dogBreed.setId((short) 1);
		dogBreed.setName("Husky");
		dogBreed.setSpecie(dogSpecies);
		var catBreed = new Breeds();
		catBreed.setId((short) 2);
		catBreed.setName("Sacré de birmanie");
		catBreed.setSpecie(catSpecies);
		List<Breeds> breeds = List.of(dogBreed, catBreed);
		Mockito.when(breedsRepository.getAllBreeds()).thenReturn(breeds);
		var fromRepository  = menuOptionsIn.getBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(dogBreed.getId(), fromRepository.get(0).getId());
		Assertions.assertEquals(dogBreed.getName(), fromRepository.get(0).getName());
		Assertions.assertEquals(dogBreed.getSpecie().getId(), fromRepository.get(0).getSpecie().getId());
		Assertions.assertEquals(dogBreed.getSpecie().getName(), fromRepository.get(0).getSpecie().getName());
		Assertions.assertEquals(catBreed.getId(), fromRepository.get(1).getId());
		Assertions.assertEquals(catBreed, fromRepository.get(1));
		Assertions.assertEquals(catBreed.getName(), fromRepository.get(1).getName());
		Assertions.assertEquals(catBreed.getSpecie().getId(), fromRepository.get(1).getSpecie().getId());
		Assertions.assertEquals(catBreed.getSpecie().getName(), fromRepository.get(1).getSpecie().getName());
		Mockito.verify(breedsRepository).getAllBreeds();
		Mockito.verifyNoMoreInteractions(speciesRepository);
	}
}
