package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.Pals;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PalsRepository implements PanacheRepository<Pals> {
}