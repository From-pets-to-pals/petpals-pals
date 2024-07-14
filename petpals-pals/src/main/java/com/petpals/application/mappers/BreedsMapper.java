package com.petpals.application.mappers;

import com.petpals.persistence.entities.Breeds;
import com.petpals.shared.model.dto.Breed;
import com.petpals.shared.model.dto.BreedWithoutSpecie;
import com.petpals.shared.model.dto.Specie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA, uses = {SpeciesMapper.class})
public interface BreedsMapper {
	Breed fromEntity(Breeds breed);
	List<Breed> fromEntities(List<Breeds> breed);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	BreedWithoutSpecie fromEntityWithoutSpecie(Breeds breed);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	List<BreedWithoutSpecie> fromEntityWithoutSpecies(List<Breeds> breed);


}
