package com.petpals.persistence.ports.in;

import com.petpals.persistence.entities.*;

import java.util.List;


public interface MenuOptionsIn {
	
	List<Countries> getCountries();
	
	List<Breeds> getBreeds();
	
	List<DogBreeds> getDogBreeds();
	List<CatBreeds> getCatBreeds();
	List<NacBreeds> getNacBreeds();
	
	List<Species> getSpecies();
	
}
