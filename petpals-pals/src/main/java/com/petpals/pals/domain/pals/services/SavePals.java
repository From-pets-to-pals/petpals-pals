package com.petpals.pals.domain.pals.services;

import com.petpals.pals.domain.owners.outputs.OwnersFinderService;
import com.petpals.pals.domain.pals.inputs.SavePalsService;
import com.petpals.pals.domain.pals.model.Owner;
import com.petpals.pals.domain.pals.model.Pals;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;
import com.petpals.pals.domain.pals.outputs.PalsFinderService;
import com.petpals.pals.domain.pals.utils.uuid.UUIDFormatter;
import com.petpals.pals.domain.pals.utils.uuid.UUIDGenerator;
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
            logger.warn("Existing owner attempting to create account");
            throw new RuntimeException("User already exist, check account recovery method");
        }
        if(palsFinderService.doICADIdentifierExist(newPal.getPalIdentityInformation().icadIdentifier())){
            logger.warn("Pet registration attempt with existing ICAD Identifier :" + newPal.getPalIdentityInformation().icadIdentifier());
            throw new RuntimeException("User already exist, check account recovery method");
        }
        setReferenceForNewPalAndOwner(newPal);
        logger.info("Creating new pal");
        palsCreatorService.createPalWithOwner(newPal);
        return "Hello world, and " + newPal.getPalIdentityInformation().name();
    }

    private static void setReferenceForNewPalAndOwner(Pals newPal) {
        String palReference = UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(),true,"");
        String ownerReference = UUIDFormatter.formatUUIDSequence(UUIDGenerator.generateUUID(),true,"");
        newPal.setFunctionalId(palReference);
        var ownerWithReference = new Owner(newPal.getOwner().email(), ownerReference, newPal.getOwner().deviceId(), newPal.getOwner().location());
        newPal.setOwner(ownerWithReference);
    }

    @Override
    public String helloPal(@NotBlank String message){
        return "Hello world, and " + message;
    }
}
