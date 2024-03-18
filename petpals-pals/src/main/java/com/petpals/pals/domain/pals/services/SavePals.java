package com.petpals.pals.domain.pals.services;

import com.petpals.pals.domain.owners.outputs.OwnersFinderService;
import com.petpals.pals.domain.pals.inputs.SavePalsService;
import com.petpals.pals.domain.pals.model.PalIdentityInformation;
import com.petpals.pals.domain.pals.model.PalMeasurement;
import com.petpals.pals.domain.pals.model.PalMedicalInformation;
import com.petpals.pals.domain.pals.model.Pals;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;
import com.petpals.pals.domain.pals.utils.uuid.UUIDFormatter;
import com.petpals.pals.domain.pals.utils.uuid.UUIDGenerator;
import com.petpals.pals.entrypoints.pals.dto.AddPal;
import jakarta.inject.Inject;
import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class SavePals implements SavePalsService {

    private static final Logger logger = LoggerFactory.getLogger(SavePalsService.class);

    private final PalsCreatorService palsCreatorService;
    private final OwnersFinderService ownersFinderService;

    public SavePals(PalsCreatorService palsCreatorService, OwnersFinderService ownersFinderService) {
        this.palsCreatorService = palsCreatorService;
        this.ownersFinderService = ownersFinderService;
    }
    @Override
    public String SavePal(AddPal newPal) {
        if(ownersFinderService.doOwnerExist(newPal.owner().email())){
            logger.info("Existing owner attempting to create account");
            throw new RuntimeException("User already exist, check account recovery method");
        }
        logger.info("Creating new pal");
        String palReference = UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(),true,"");
        logger.info("Generating reference for Pal : ".concat(palReference));
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

        Pals palToRegister = new Pals(
                null,
                palReference,
                palMedicalInformation,
                palIdentityInformation,
                palMeasurement,
                1L,
                false);
        palsCreatorService.createPalWithOwner(palToRegister);
        return "Hello world, and " + newPal.name();
    }
@Override
    public String helloPal(@NotBlank String message){
        return "Hello world, and " + message;
    }
}
