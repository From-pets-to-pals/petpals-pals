package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.NacBreeds;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NacBreedsRepository implements PanacheRepository<NacBreeds> {
}
