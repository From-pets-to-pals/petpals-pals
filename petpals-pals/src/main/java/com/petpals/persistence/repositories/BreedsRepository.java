package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.Breeds;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BreedsRepository implements PanacheRepository<Breeds> {
	public List<Breeds> getAllBreeds(){
		return listAll(Sort.by("specie"));
	}
	public List<Breeds> getAllDogBreeds(){
		return list("specie.id", (short) 1);
	}
	public List<Breeds> getAllCatBreeds(){
		return list("specie.id", (short) 2);
	}
	public List<Breeds> getAllNacBreeds(){
		return list("specie.id", (short) 3);
	}
	public Short getBreedIdFromItsName(String breedName){
		return find("name",breedName).firstResult().getId();
	}
}
