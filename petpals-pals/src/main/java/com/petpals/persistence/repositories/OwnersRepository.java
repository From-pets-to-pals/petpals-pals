package com.petpals.persistence.repositories;

import com.petpals.persistence.entities.Owners;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class OwnersRepository implements PanacheRepository<Owners> {
}
