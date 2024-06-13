package com.petpals.persistence.services;

import com.petpals.persistence.entities.Breeds;
import com.petpals.persistence.entities.Countries;
import com.petpals.persistence.entities.Species;
import com.petpals.persistence.ports.in.MenuOptionsIn;
import com.petpals.persistence.repositories.BreedsRepository;
import com.petpals.persistence.repositories.CountriesRepository;
import com.petpals.persistence.repositories.SpeciesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

import java.util.List;


@ApplicationScoped
public class MenuOptions implements MenuOptionsIn {
	
	BreedsRepository breedsRepository;
	
	SpeciesRepository speciesRepository;
	
	CountriesRepository countriesRepository;
	
	public MenuOptions(BreedsRepository breedsRepository, SpeciesRepository speciesRepository, CountriesRepository countriesRepository) {
		this.breedsRepository = breedsRepository;
		this.speciesRepository = speciesRepository;
		this.countriesRepository = countriesRepository;
	}
	
	@Override
	public List<Countries> getCountries() {
		return countriesRepository.getAllCountries();
	}
	
	@Override
	public List<Breeds> getBreeds() {
		Logger.getLogger(MenuOptions.class.getName()).info(breedsRepository.getAllBreeds());
		return breedsRepository.getAllBreeds();
	}
	
	@Override
	public List<Species> getSpecies() {
		Logger.getLogger(MenuOptions.class.getName()).info(speciesRepository.getAllSpecies());
		
		return speciesRepository.getAllSpecies();
	}
}
