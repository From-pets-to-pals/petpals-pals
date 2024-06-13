package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.Countries;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CountriesRepository  implements PanacheRepository<Countries> {
	public List<Countries> getAllCountries() {
		return list("name", "France");
	}
}
