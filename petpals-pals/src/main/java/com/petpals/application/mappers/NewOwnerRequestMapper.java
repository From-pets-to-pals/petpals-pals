package com.petpals.application.mappers;

import com.petpals.application.dto.NewOwnerRequest;
import com.petpals.persistence.entities.Owners;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", uses = {AddPalRequestMapper.class})
public interface NewOwnerRequestMapper {
	Owners toEntity(NewOwnerRequest request);
}
