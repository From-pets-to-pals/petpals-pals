package com.petpals.pals.persistence;

import com.petpals.pals.persistence.repositories.OwnersRepositorySpecs;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest(startApplication = false)
public class OwnersRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(OwnersRepositoryTest.class);

    @Inject
    OwnersRepositorySpecs ownersRepository;

    @Test
    public void shouldFindOneOwner(){
        var owners = ownersRepository.findAll();
        logger.info(owners.toString());
        assertEquals("sae.bennaceur@gmail.com", owners.get(0).getMail());
    }
}
