package com.petpals.application.mappers;

import com.petpals.application.dto.NewOwnerRequest;
import com.petpals.persistence.entities.Owners;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA, uses = {AddPalRequestMapper.class})
public interface NewOwnerRequestMapper {
	@Mapping(target = "id", ignore = true)
	Owners toEntity(NewOwnerRequest request);
}
