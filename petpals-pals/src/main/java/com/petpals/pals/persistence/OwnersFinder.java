package com.petpals.pals.persistence;

import com.petpals.pals.domain.pals.outputs.OwnersFinderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnersFinder implements OwnersFinderService {
    private static final Logger logger = LoggerFactory.getLogger(OwnersFinder.class);

    @Override
    public boolean doOwnerExist(String email) {
        logger.info("sasasasa");
        logger.info(String.valueOf(email.contentEquals("sa.bennaceur@gmail.com")));
        return email.contentEquals("sa.bennaceur@gmail.com");
    }
}
