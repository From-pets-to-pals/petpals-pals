package com.petpals.pals.bootstrap.di;

import com.petpals.pals.domain.pals.outputs.OwnersFinderService;
import com.petpals.pals.domain.pals.outputs.PalsFinderService;
import com.petpals.pals.domain.pals.services.SavePals;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;
import com.petpals.pals.domain.pals.inputs.SavePalsService;
import com.petpals.pals.persistence.inputs.OwnersFinder;
import com.petpals.pals.persistence.inputs.PalsCreator;
import com.petpals.pals.persistence.inputs.PalsFinder;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class BeanFactory {

    @Bean
    PalsFinderService palsFInderService(){
        return new PalsFinder();
    }

    @Bean
    PalsCreatorService palsCreatorService(){
        return new PalsCreator();
    }

    @Bean
    OwnersFinderService ownersFinderService(){
        return new OwnersFinder();
    }

    @Singleton
    SavePalsService savePalService(PalsCreatorService palsCreatorService,PalsFinderService palsFinderService, OwnersFinderService ownersFinderService){
        return new SavePals(palsCreatorService, palsFinderService, ownersFinderService);
    }
}
