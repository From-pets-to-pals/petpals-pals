package com.petpals.pals.persistence;

import com.petpals.pals.domain.pals.model.Pals;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;
import com.petpals.pals.persistence.repositories.OwnersRepository;
import jakarta.inject.Inject;

public class PalsCreator implements PalsCreatorService {
    @Inject
    OwnersRepository ownersRepository;
    @Override
    public Long createPalWithOwner(Pals palWithOwner) {
        return FakeDB.addToDb(palWithOwner);
    }
}
