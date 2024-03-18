package com.petpals.pals.persistence;

import com.petpals.pals.domain.pals.outputs.PalsFinderService;

public class PalsFinder implements PalsFinderService {
    @Override
    public boolean doICADIdentifierExist(String ICADIdentifier) {
        return false;
    }
}
