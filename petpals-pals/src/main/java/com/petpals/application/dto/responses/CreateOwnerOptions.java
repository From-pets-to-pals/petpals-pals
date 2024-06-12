package com.petpals.application.dto.responses;

import com.petpals.shared.model.Breed;
import com.petpals.shared.model.Country;
import com.petpals.shared.model.Species;

import java.util.List;

public record CreateOwnerOptions(List<Country> countries, List<Species> species, List<Breed> breeds) {
}
