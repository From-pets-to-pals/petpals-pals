package com.petpals.pals.persistence.inputs;

import com.petpals.pals.domain.pals.outputs.OwnersFinderService;
import com.petpals.pals.persistence.service.OwnersRepository;
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
        var dbResponse = ownersRepository.findByEmail(email);
        return dbResponse.isPresent();
    }
}
