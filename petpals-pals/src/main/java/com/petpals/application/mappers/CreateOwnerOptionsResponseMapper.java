package com.petpals.application.mappers;

import com.petpals.application.dto.responses.CreateOwnerOptions;
import com.petpals.persistence.entities.Breeds;
import com.petpals.persistence.entities.Countries;
import com.petpals.persistence.entities.Species;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA,
		uses = {BreedsMapper.class, SpeciesMapper.class, CountriesMapper.class})
public interface CreateOwnerOptionsResponseMapper {
	CreateOwnerOptions toResponse(List<Countries> countries, List<Species> species, List<Breeds> breeds);
}
