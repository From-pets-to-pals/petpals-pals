package com.petpals.application.dto.responses;

import com.petpals.shared.model.Country;
import com.petpals.shared.model.Species;

import java.util.List;

public record CreateCaregiverOptions(List<Country> countries, List<Species> species) {
}
