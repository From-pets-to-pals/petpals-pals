package com.petpals.application.mappers;

import com.petpals.persistence.entities.Breeds;
import com.petpals.shared.model.Breed;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface BreedsMapper {
	Breed fromEntity(Breeds breed);
	List<Breed> fromEntities(List<Breeds> breed);
}
