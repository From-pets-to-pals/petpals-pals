package com.petpals.pals.entrypoints.pals.controllers;

import com.petpals.pals.domain.pals.model.*;
import com.petpals.pals.entrypoints.pals.dto.AddFirstPal;
import com.petpals.pals.domain.pals.inputs.SavePalsService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.HeaderParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Header(name="API-KEY")
@Controller(value = "/pals")
public class SavePalController {
    private static final Logger logger = LoggerFactory.getLogger(SavePalController.class);
    private final SavePalsService palService;
    public SavePalController(SavePalsService savePalsService) {
        this.palService = savePalsService;
    }
 

    @Post(produces = MediaType.TEXT_PLAIN, consumes =  MediaType.APPLICATION_JSON) // (2)
    public Pals createFirstPalWithOwner(@Valid AddFirstPal newPal) {
        logger.info("Calling createFirstPalWithOwner");
        logger.info("Received new payload for newPal :" + newPal);
        PalIdentityInformation palIdentityInformation = new PalIdentityInformation(
                newPal.name(),
                newPal.birthDate(),
                newPal.isMale(),
                newPal.specie(),
                newPal.race(),
                newPal.icadIdentifier(),
                newPal.hasPassport()
        );

        PalMeasurement palMeasurement = new PalMeasurement(newPal.weight(), newPal.weight());
        PalMedicalInformation palMedicalInformation = new PalMedicalInformation(
                newPal.isVaccinated(),
                new ArrayList<>(),
                null,
                null,
                newPal.isSterilized());
        Owner palOwner = new Owner(newPal.owner().email(), newPal.owner().functionalId(), newPal.owner().deviceId(), newPal.owner().location());
        Pals palToRegister = new Pals(
                null,
                null,
                palMedicalInformation,
                palIdentityInformation,
                palMeasurement,
                palOwner,
                false);
        return  palService.SavePal(palToRegister); // (3)
    }

    @Get(produces = MediaType.TEXT_PLAIN, consumes = MediaType.TEXT_PLAIN, value = "/{helloPal}")
    public String helloPal(@NotBlank @PathVariable("helloPal") String pal){
        logger.info("Calling Hello");
        return palService.helloPal(pal);
    }
}

