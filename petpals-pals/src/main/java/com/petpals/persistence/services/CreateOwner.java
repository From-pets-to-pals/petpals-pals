package com.petpals.persistence.services;

import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.ports.in.CreateOwnerIn;
import com.petpals.persistence.repositories.BreedsRepository;
import com.petpals.persistence.repositories.OwnersRepository;
import com.petpals.shared.errorhandling.ExceptionsEnum;
import com.petpals.shared.errorhandling.PetPalsExceptions;
import com.petpals.shared.model.enums.SpeciesEnum;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CreateOwner implements CreateOwnerIn {
	private static final Logger LOG = Logger.getLogger(CreateOwner.class);


	private final OwnersRepository ownersRepository;
	private final BreedsRepository breedsRepository;
	public CreateOwner(OwnersRepository ownersRepository, BreedsRepository breedsRepository) {
		this.ownersRepository = ownersRepository;
		this.breedsRepository = breedsRepository;
	}

	@Transactional(rollbackOn = {PetPalsExceptions.class}, value = Transactional.TxType.REQUIRED)
	@Override
	public Long createOwnerWithFirstPal(Owners owner) {
		LOG.info("Creating owner with first pal");
		try {
			for(var pal: owner.getPals()) {
				if(pal.getSpecie().getName().equals(SpeciesEnum.DOG.name())){
					pal.getSpecie().setId((short) 1);
				} else if(pal.getSpecie().getName().equals(SpeciesEnum.CAT.name())){
					pal.getSpecie().setId((short) 2);
					
				} else {
					pal.getSpecie().setId((short) 3);
				}
				
				pal.getBreed().setId(breedsRepository.getBreedIdFromItsName(pal.getBreed().getName()));
			}
			return ownersRepository.save(owner);
		} catch (ConstraintViolationException e){
			LOG.info(e.getErrorMessage());
			throw new PetPalsExceptions(ExceptionsEnum.DB_UNIQUE_KEY_OWNER_MAIL_CONSTRAINT_VIOLATION);
		}
	}
}