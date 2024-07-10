package com.petpals.persistence.ports.in;

import com.petpals.persistence.entities.Owners;

public interface ProfileIn {
	Owners getOwnersWithPals(String reference);
}
