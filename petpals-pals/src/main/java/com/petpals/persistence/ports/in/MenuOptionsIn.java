package com.petpals.persistence.ports.in;

import com.petpals.persistence.entities.*;

import java.util.List;


public interface MenuOptionsIn {
	
	List<Countries> getCountries();
	
	List<Breeds> getBreeds();
	
	List<Breeds> getDogBreeds();
	List<Breeds> getCatBreeds();
	List<Breeds> getNacBreeds();
	
	List<Species> getSpecies();
	
}
