package com.petpals.application.mappers;

import com.petpals.persistence.entities.Breeds;
import com.petpals.shared.model.dto.Breed;
import com.petpals.shared.model.dto.BreedWithoutSpecie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA, uses = {SpeciesMapper.class})
public interface BreedsMapper {
	Breed fromEntity(Breeds breed);
	List<Breed> fromEntities(List<Breeds> breed);
	BreedWithoutSpecie fromEntityWithoutSpecie(Breeds breed);
	List<BreedWithoutSpecie> FromEntitiesWithoutSpecies(List<Breeds> breed);
}
