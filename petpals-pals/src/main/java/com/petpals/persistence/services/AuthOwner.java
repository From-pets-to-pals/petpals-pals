package com.petpals.persistence.services;

import com.petpals.persistence.dto.AuthOwnerDto;
import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.ports.in.AuthOwnerIn;
import com.petpals.persistence.repositories.OwnersRepository;
import com.petpals.shared.errorhandling.ExceptionsEnum;
import com.petpals.shared.errorhandling.PetPalsExceptions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AuthOwner implements AuthOwnerIn {

    private static final Logger LOG = Logger.getLogger(CreateOwner.class);
    private final OwnersRepository ownersRepository;

    public AuthOwner(OwnersRepository ownersRepository) {
        this.ownersRepository = ownersRepository;
    }

    @Transactional(rollbackOn = {PetPalsExceptions.class}, value = Transactional.TxType.REQUIRED)
    @Override
    public String authOwner(AuthOwnerDto authOwner) {
        String reference = ownersRepository.authUser(authOwner);
        if (reference != null) {
            return reference;
        } else {
            throw new PetPalsExceptions(ExceptionsEnum.CAREGIVERS_SERVICE_INVALID_COMMAND);
        }
    }
}
