package com.petpals.pals.persistence;

import com.petpals.pals.domain.owners.outputs.OwnersFinderService;

public class OwnersFinder implements OwnersFinderService {
    @Override
    public boolean doOwnerExist(String email) {
        return false;
    }
}
