package com.petpals.pals.persistence.inputs;

import com.petpals.pals.domain.pals.model.Pals;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;
import com.petpals.pals.persistence.FakeDB;
import com.petpals.pals.persistence.service.OwnersRepository;
import jakarta.inject.Inject;

public class PalsCreator implements PalsCreatorService {
    @Inject
    OwnersRepository ownersRepository;
    @Override
    public Long createPalWithOwner(Pals palWithOwner) {
        return FakeDB.addToDb(palWithOwner);
    }
}
