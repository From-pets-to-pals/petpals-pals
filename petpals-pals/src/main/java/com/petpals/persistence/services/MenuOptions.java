package com.petpals.persistence.services;

import com.petpals.persistence.entities.*;
import com.petpals.persistence.ports.in.MenuOptionsIn;
import com.petpals.persistence.repositories.*;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

import java.util.List;


@ApplicationScoped
public class MenuOptions implements MenuOptionsIn {
	
	BreedsRepository breedsRepository;
	
	CatBreedsRepository catBreedsRepository;
	
	DogBreedsRepository dogBreedsRepository;
	
	NacBreedsRepository nacBreedsRepository;
	
	SpeciesRepository speciesRepository;
	
	CountriesRepository countriesRepository;
	
	public MenuOptions(BreedsRepository breedsRepository, CatBreedsRepository catBreedsRepository, DogBreedsRepository dogBreedsRepository, NacBreedsRepository nacBreedsRepository, SpeciesRepository speciesRepository, CountriesRepository countriesRepository) {
		this.breedsRepository = breedsRepository;
		this.catBreedsRepository = catBreedsRepository;
		this.dogBreedsRepository = dogBreedsRepository;
		this.nacBreedsRepository = nacBreedsRepository;
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
	public List<DogBreeds> getDogBreeds() {
		return dogBreedsRepository.listAll();
	}
	
	@Override
	public List<CatBreeds> getCatBreeds() {
		return catBreedsRepository.listAll();
	}
	
	@Override
	public List<NacBreeds> getNacBreeds() {
		return nacBreedsRepository.listAll();
	}
	
	@Override
	public List<Species> getSpecies() {
		Logger.getLogger(MenuOptions.class.getName()).info(speciesRepository.getAllSpecies());
		
		return speciesRepository.getAllSpecies();
	}
}
