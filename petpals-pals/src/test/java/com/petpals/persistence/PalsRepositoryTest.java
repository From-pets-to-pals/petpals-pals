package com.petpals.persistence;

import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.entities.Pals;
import com.petpals.persistence.ports.in.CreateOwnerIn;
import com.petpals.persistence.repositories.OwnersRepository;
import com.petpals.persistence.repositories.PalsRepository;
import com.petpals.persistence.services.CreateOwner;
import com.petpals.shared.entities.uuid.UUIDFormatter;
import com.petpals.shared.entities.uuid.UUIDGenerator;
import com.petpals.shared.errorhandling.PetPalsExceptions;
import io.quarkus.test.InjectMock;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@QuarkusTest
class PalsRepositoryTest {

    @InjectMock
    public OwnersRepository ownersRepository;
    @Inject
    CreateOwnerIn createOwnerIn;

    private Owners owners;

    private final ArgumentCaptor<Owners> ownersArgumentCaptor = ArgumentCaptor.forClass(Owners.class);

    @BeforeEach
    public void init() {
        var ownerUUID = UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(),true,"");
        var palUUID = UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(),true,"");

        owners = new Owners("sa.bennaceur@gmail.com", "OPPO XC9" , ownerUUID, "FRANCE");
        Pals pals = new Pals("Tobby", "Tobby", "152356545784512", owners, new Date(Instant.now().getEpochSecond()), "DOG", "Berger " +
                "Américain", true,
                true,
                true, true, null, null, palUUID);
        owners.setPalsList(List.of(pals));
    }
    @Test
    @TestTransaction
    public void testAddOwnerWithPals() {
        Mockito.when(ownersRepository.save(owners)).thenReturn(1L);
        var res = createOwnerIn.createOwnerWithFirstPal(owners);
        Mockito.verify(ownersRepository).save(ownersArgumentCaptor.capture());
        Assertions.assertEquals(1L, res);
        Assertions.assertEquals(owners.getReference(),ownersArgumentCaptor.getValue().getReference());
    }

    @Test
    @TestTransaction
    public void testAddOwnerShouldThrowPetPalsException() {
        Mockito.when(ownersRepository.save(owners)).thenThrow(ConstraintViolationException.class);
        Assertions.assertThrows(PetPalsExceptions.class, () -> createOwnerIn.createOwnerWithFirstPal(owners));
        Mockito.verify(ownersRepository).save(ownersArgumentCaptor.capture());
        Assertions.assertEquals(owners.getReference(),ownersArgumentCaptor.getValue().getReference());
    }
}