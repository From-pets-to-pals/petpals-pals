package com.petpals.application.mappers;

import com.petpals.application.dto.AuthOwnerRequest;
import com.petpals.persistence.dto.AuthOwnerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.text.ParseException;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface AuthOwnerRequestMapper {
	@Mapping(target = "email", source = "email")
	@Mapping(target = "password", source = "password")
	AuthOwnerDto toEntity(AuthOwnerRequest request) throws ParseException;


}
