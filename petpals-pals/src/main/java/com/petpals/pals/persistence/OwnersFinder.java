package com.petpals.pals.persistence;

import com.petpals.pals.domain.pals.outputs.OwnersFinderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnersFinder implements OwnersFinderService {
    private static final Logger logger = LoggerFactory.getLogger(OwnersFinder.class);

    @Override
    public boolean doOwnerExist(String email) {
        logger.info("Do owner Exist");
        return FakeDB.doOwnerExist(email);
    }
}
