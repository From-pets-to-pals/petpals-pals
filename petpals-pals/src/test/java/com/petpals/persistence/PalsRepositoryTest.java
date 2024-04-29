package com.petpals.persistence;

import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.entities.Pals;
import com.petpals.persistence.repositories.PalsRepository;
import com.petpals.shared.entities.uuid.UUIDFormatter;
import com.petpals.shared.entities.uuid.UUIDGenerator;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Instant;

@QuarkusTest
class PalsRepositoryTest {

    @Inject
    public PalsRepository palsRepository;

    private Pals pals;

    @BeforeEach
    public void init() {
        var ownerUUID = UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(),true,"");
        var palUUID = UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(),true,"");

        var owners = new Owners("sa.bennaceur@gmail.com", "OPPO XC9" , ownerUUID, "FRANCE");
        pals = new Pals("Tobby", "Tobby", "152356545784512", owners, new Date(Instant.now().getEpochSecond()), "DOG", "Berger " +
                                                                                                            "Américain", true,
                            true,
                            true, true, null, null, palUUID);

    }
    @Test
    public void testAddPals() {
        //palsRepository.persistAndFlush(pals);
    }
}