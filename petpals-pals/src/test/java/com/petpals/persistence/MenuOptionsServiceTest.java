package com.petpals.persistence;

import com.petpals.persistence.entities.CatBreeds;
import com.petpals.persistence.entities.DogBreeds;
import com.petpals.persistence.entities.NacBreeds;
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
		doggoA.setName("Husky de Sibérie");
		var doggoB = new DogBreeds();
		doggoB.setName("Pinscher")	;
		List<DogBreeds> dogBreeds = List.of(doggoA, doggoB);
		Mockito.when(dogBreedsRepository.listAll()).thenReturn(dogBreeds);
		var fromRepository  = menuOptionsIn.getDogBreeds();
		Assertions.assertEquals(2, fromRepository.size());
		Assertions.assertEquals(doggoA.getName(), dogBreeds.get(0).getName());
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
}
