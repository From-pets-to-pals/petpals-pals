package com.petpals.pals.persistence;

import com.petpals.pals.domain.pals.outputs.OwnersFinderService;
import com.petpals.pals.persistence.repositories.OwnersRepository;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnersFinder implements OwnersFinderService {
    private static final Logger logger = LoggerFactory.getLogger(OwnersFinder.class);

    @Inject
    OwnersRepository ownersRepository;
    @Override
    public boolean doOwnerExist(String email) {
        logger.info("Do owner Exist");
        return FakeDB.doOwnerExist(email);
    }
}
