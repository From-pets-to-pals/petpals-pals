package com.petpals.application.mappers;

import com.petpals.persistence.entities.Species;
import com.petpals.shared.model.Specie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface SpeciesMapper {
	Specie fromEntity(Species speciesEntity);
	
	List<Specie> fromEntities(List<Species> speciesEntity);
	
}
