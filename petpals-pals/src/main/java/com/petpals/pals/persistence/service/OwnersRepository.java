package com.petpals.pals.persistence.service;

import com.petpals.pals.persistence.entities.Owners;
import com.petpals.pals.persistence.repositories.OwnersRepositorySpecs;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

@Singleton
public class OwnersRepository implements OwnersRepositorySpecs {

    private final EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public OwnersRepository(EntityManager entityManager,
                            ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Override
    @ReadOnly
    public Optional<Owners> findById(long id) {
        return Optional.ofNullable(entityManager.find(Owners.class, id));
    }

    @Override
    @Transactional
    public Long save(Owners owners) {
        entityManager.persist(owners);
        return owners.getId();
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @ReadOnly
    public List<Owners> findAll() {
        String qlString = "SELECT g FROM Owners as g";
        TypedQuery<Owners> query = entityManager.createQuery(qlString, Owners.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public int update(long id, @NotBlank String deviceName) {
        return entityManager.createQuery("UPDATE Owners o SET device = :name where id = :id")
                .setParameter("name", deviceName)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @ReadOnly
    public Optional<Owners> findByEmail(String email) {
        var owner = entityManager.find(Owners.class, email);
        return  Optional.ofNullable(owner);
    }

}
