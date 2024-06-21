package com.petpals.application.mappers;

import com.petpals.application.dto.AddPalRequest;

import com.petpals.persistence.entities.Pals;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface AddPalRequestMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "owner", ignore = true)
	@Mapping( target = "birthDate", dateFormat = "yyyy-MM-dd", expression = "java(toDate" +
																									   "(request" +
																									   ".birthDate" +
																									   "()))")
	@Mapping( target = "nextVaccine", dateFormat = "yyyy-MM-dd", expression = "java(toDate" +
																					"(request" +
																					".nextVaccine" +
																					"()))")
	@Mapping( target = "nextPlannedVetApp", dateFormat = "yyyy-MM-dd", expression = "java(toDate" +
																					  "(request" +
																					  ".nextPlannedVetApp" +
																					  "()))")
	@Mapping(source="breed", target = "breed.name")
	Pals toEntity(AddPalRequest request) throws ParseException;
	
	
	default Date toDate(String stringDate) throws ParseException {
		if(stringDate == null){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
		return new Date(formatter.parse(stringDate).getTime());
	}
}
