package com.petpals.pals.persistence;

import com.petpals.pals.domain.pals.model.Pals;
import com.petpals.pals.domain.pals.outputs.PalsCreatorService;

public class PalsCreator implements PalsCreatorService {
    @Override
    public Long createPalWithOwner(Pals palWithOwner) {
        return FakeDB.addToDb(palWithOwner);
    }
}
