package com.petpals.persistence.services;

import com.petpals.persistence.entities.*;
import com.petpals.persistence.ports.in.MenuOptionsIn;
import com.petpals.persistence.repositories.*;
import jakarta.enterprise.context.ApplicationScoped;

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
		return breedsRepository.getAllBreeds();
	}
	
	@Override
	public List<Breeds> getDogBreeds() {
		return breedsRepository.getAllDogBreeds();
	}
	
	@Override
	public List<Breeds> getCatBreeds() {
		return breedsRepository.getAllCatBreeds();
		
	}
	
	@Override
	public List<Breeds> getNacBreeds() {
		return breedsRepository.getAllNacBreeds();
		
	}
	
	@Override
	public List<Species> getSpecies() {
		return speciesRepository.getAllSpecies();
	}
}
