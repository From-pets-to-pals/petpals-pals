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
}