package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.DogBreeds;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogBreedsRepository implements PanacheRepository<DogBreeds> {
}
