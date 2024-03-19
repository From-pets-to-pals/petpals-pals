package com.petpals.pals.domain.service;

import com.petpals.pals.domain.pals.inputs.SavePalsService;
import com.petpals.pals.domain.pals.model.*;
import com.petpals.pals.domain.pals.outputs.OwnersFinderService;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;
import com.petpals.pals.domain.pals.outputs.PalsFinderService;
import com.petpals.pals.persistence.inputs.OwnersFinder;
import com.petpals.pals.persistence.inputs.PalsCreator;
import com.petpals.pals.persistence.inputs.PalsFinder;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.mock;

@MicronautTest(startApplication = false)
public class SavePalsTest {
    @MockBean(PalsCreator.class)
    PalsCreatorService palsCreatorService(){
        return mock(PalsCreatorService.class);
    }
    @MockBean(PalsFinder.class)
    PalsFinderService palsFinderService(){
        return mock(PalsFinderService.class);
    }
    @Inject
    OwnersFinderService ownersFinderService;
    @MockBean(OwnersFinder.class)
    OwnersFinderService ownersFinderService(){
        return mock(OwnersFinderService.class);
    }
    @Inject
    SavePalsService savePalsService;

    private static Pals pal;
    @BeforeAll
    public static void setup(){
        var ownerMail = "sa.bennaceur@gmail.com";
        Pals fakePal = new Pals();
        PalMedicalInformation palMedicalInformation = new PalMedicalInformation(
                true,
                new ArrayList<>(),
                null,
                null,
                true
        );
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation(
                "Ash",
                new Date(),
                true,
                Species.DOG,
                "Bergar Américain",
                "250260000000000",
                true
        );
        PalMeasurement palMeasurement = new PalMeasurement(
                10.0,
                35.0
        );
        Owner testOwner = new Owner(ownerMail,null,"OPPOXC9","Paris, France");
        fakePal.setOwner(testOwner);
        fakePal.setPalMeasurement(palMeasurement);
        fakePal.setPalIdentityInformation(palIdentityInformation);
        fakePal.setPalMedicalInformation(palMedicalInformation);
        fakePal.setHasDied(false);
        pal = fakePal;
    }

    @Test
    public void shouldThrowErrorWhenOwnerExists(){
        //Mockito.when(ownersFinderService.doOwnerExist(pal.getOwner().email())).thenReturn(true);
        //(PalsException.class, () -> savePalsService.SavePal(pal));
    }
}
