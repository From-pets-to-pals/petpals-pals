package com.petpals.application.mappers;

import com.petpals.application.dto.responses.CreateCaregiverOptions;
import com.petpals.persistence.entities.Countries;
import com.petpals.persistence.entities.Species;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA,
uses = {SpeciesMapper.class, CountriesMapper.class})
public interface CreateCaregiverOptionsResponseMapper {
	CreateCaregiverOptions toResponse(List<Countries> countries, List<Species> species);
}
