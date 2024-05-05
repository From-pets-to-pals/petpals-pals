package com.petpals.application.mappers;

import com.petpals.application.dto.AddPalRequest;
import com.petpals.bootstrap.quarkusapp.Pals;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface AddPalRequestMapper {
	Pals toEntity(AddPalRequest request);
	List<Pals> toEntities(List<AddPalRequest> pals);
}
