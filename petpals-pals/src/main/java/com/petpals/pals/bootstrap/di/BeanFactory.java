package com.petpals.pals.bootstrap.di;

import com.petpals.pals.domain.owners.outputs.OwnersFinderService;
import com.petpals.pals.domain.pals.services.SavePals;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;
import com.petpals.pals.domain.pals.inputs.SavePalsService;
import com.petpals.pals.persistence.OwnersFinder;
import com.petpals.pals.persistence.PalsCreator;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class BeanFactory {

    @Singleton
    PalsCreatorService palsCreatorService(){
        return new PalsCreator();
    }

    @Singleton
    OwnersFinderService ownersFinderService(){
        return new OwnersFinder();
    }

    @Singleton
    SavePalsService savePalService(PalsCreatorService palsCreatorService, OwnersFinderService ownersFinderService){
        return new SavePals(palsCreatorService, ownersFinderService);
    }
}
