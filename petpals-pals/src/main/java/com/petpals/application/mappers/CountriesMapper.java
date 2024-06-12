package com.petpals.application.mappers;

import com.petpals.shared.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface CountriesMapper {
	Country fromEntity(Coun entity);
}
