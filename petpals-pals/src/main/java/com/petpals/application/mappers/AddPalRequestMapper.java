package com.petpals.application.mappers;

import com.petpals.application.dto.AddPalRequest;

import com.petpals.persistence.entities.Pals;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface AddPalRequestMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "owner", ignore = true)
	
	Pals toEntity(AddPalRequest request);
}
