package com.petpals.persistence.services;

import com.petpals.persistence.entities.Pals;
import com.petpals.persistence.ports.in.CreateOwnerIn;
import com.petpals.persistence.repositories.OwnersRepository;
import com.petpals.persistence.repositories.PalsRepository;
import com.petpals.shared.errorhandling.PetPalsExceptions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CreateOwner implements CreateOwnerIn {
	private final Logger LOG = Logger.getLogger(CreateOwner.class);
	
	private final PalsRepository palsRepository;
	
	private final OwnersRepository ownersRepository;
	
	public CreateOwner(PalsRepository palsRepository, OwnersRepository ownersRepository) {
		this.palsRepository = palsRepository;
		this.ownersRepository = ownersRepository;
	}
	
	@Transactional(rollbackOn = {PetPalsExceptions.class}, value = Transactional.TxType.REQUIRED)
	@Override
	public String createOwnerWithFirstPal(Pals pal) {
		LOG.info("Creating owner with first pal");
		ownersRepository.persist(pal.getOwner());
		palsRepository.persistAndFlush(pal);
		return "Ok";
	}
}