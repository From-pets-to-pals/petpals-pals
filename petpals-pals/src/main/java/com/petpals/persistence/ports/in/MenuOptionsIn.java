package com.petpals.persistence.ports.in;

import com.petpals.application.dto.responses.CreateCaregiverOptions;

import java.util.List;

public interface MenuOptionsIn {
	
	List<CreateCaregiverOptions> getCreateCaregiverOptions();
	
	List<CreateOwnerOptions> getCreateOwnerOptions();
	
}
