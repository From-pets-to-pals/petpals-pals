package com.petpals.pals.persistence.repositories;

import com.petpals.pals.persistence.entities.Owners;
import io.micronaut.data.annotation.Query;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

public interface OwnersRepositorySpecs {
    Optional<Owners> findById(long id);
    Optional<Owners> findByEmail(String email);

    @Query(value = "INSERT INTO petpals.owners(email, reference, device, location) values(:email, :reference, :device, :location) RETURNING id",
    nativeQuery = true)
    Long save(Owners owners);


    void deleteById(long id);

    List<Owners> findAll();

    int update(long id, @NotBlank String name);
}
