package com.petpals.application.mappers;

import com.petpals.persistence.entities.Species;
import com.petpals.shared.model.dto.Specie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface SpeciesMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	Specie fromEntity(Species speciesEntity);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	List<Specie> fromEntities(List<Species> speciesEntity);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	Species toEntity(Specie specie);


}
