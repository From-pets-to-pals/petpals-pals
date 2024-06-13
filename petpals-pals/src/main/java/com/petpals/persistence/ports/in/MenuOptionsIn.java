package com.petpals.persistence.ports.in;

import com.petpals.persistence.entities.Breeds;
import com.petpals.persistence.entities.Countries;
import com.petpals.persistence.entities.Species;

import java.util.List;


public interface MenuOptionsIn {
	
	List<Countries> getCountries();
	
	List<Breeds> getBreeds();
	
	List<Species> getSpecies();
	
}
