package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.CatBreeds;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatBreedsRepository implements PanacheRepository<CatBreeds> {
}
