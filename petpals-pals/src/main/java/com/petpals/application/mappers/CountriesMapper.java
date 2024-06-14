package com.petpals.application.mappers;

import com.petpals.persistence.entities.Countries;
import com.petpals.shared.model.dto.Country;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface CountriesMapper {
	Country fromEntity(Countries entity);
	
	List<Country> fromEntities(List<Countries> entities);
}
