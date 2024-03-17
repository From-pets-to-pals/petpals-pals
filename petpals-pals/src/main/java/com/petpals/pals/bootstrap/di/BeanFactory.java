package com.petpals.pals.bootstrap.di;

import com.petpals.pals.domain.pals.inputs.SavePals;
import com.petpals.pals.domain.pals.services.SavePalsService;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Prototype;

@Factory
public class BeanFactory {

    @Prototype
    SavePalsService savePalService(){
        return new SavePals();
    }
}
