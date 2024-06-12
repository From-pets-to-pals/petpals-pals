package com.petpals.persistence.services;

import com.petpals.application.dto.responses.CreateCaregiverOptions;
import com.petpals.persistence.ports.in.MenuOptionsIn;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MenuOptions implements MenuOptionsIn {
	@Override
	public List<CreateCaregiverOptions> getCreateCaregiverOptions() {
		return null;
	}
	
	@Override
	public List<CreateOwnerOptions> getCreateOwnerOptions() {
		return null;
	}
}
