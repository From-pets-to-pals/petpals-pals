package com.petpals.pals.domain.pals.services;

import com.petpals.pals.domain.owners.outputs.OwnersFinderService;
import com.petpals.pals.domain.pals.inputs.SavePalsService;
import com.petpals.pals.domain.pals.model.*;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;
import com.petpals.pals.domain.pals.outputs.PalsFinderService;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavePals implements SavePalsService {

    private static final Logger logger = LoggerFactory.getLogger(SavePalsService.class);

    private final PalsFinderService palsFinderService;
    private final OwnersFinderService ownersFinderService;
    private final PalsCreatorService palsCreatorService;

    public SavePals(PalsCreatorService palsCreatorService, PalsFinderService palsFinderService, OwnersFinderService ownersFinderService) {
        this.palsFinderService = palsFinderService;
        this.ownersFinderService = ownersFinderService;
        this.palsCreatorService = palsCreatorService;
    }
    @Override
    public String SavePal(Pals newPal) {
        if(ownersFinderService.doOwnerExist(newPal.getOwner().email())){
            logger.info("Existing owner attempting to create account");
            throw new RuntimeException("User already exist, check account recovery method");
        }
        if(palsFinderService.doICADIdentifierExist(newPal.getPalIdentityInformation().icadIdentifier())){
            logger.info("Pet registration attempt with existing ICAD Identifier :" + newPal.getPalIdentityInformation().icadIdentifier());
            throw new RuntimeException("User already exist, check account recovery method");
        }
        logger.info("Creating new pal");
        palsCreatorService.createPalWithOwner(newPal);
        return "Hello world, and " + newPal.getPalIdentityInformation().name();
    }
@Override
    public String helloPal(@NotBlank String message){
        return "Hello world, and " + message;
    }
}
