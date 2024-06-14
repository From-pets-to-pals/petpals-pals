package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.Species;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SpeciesRepository implements PanacheRepository<Species> {
	public List<Species> getAllSpecies() {
		return listAll();
	}
}
