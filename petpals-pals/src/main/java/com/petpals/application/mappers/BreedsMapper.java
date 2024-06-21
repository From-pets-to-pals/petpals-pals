package com.petpals.application.mappers;

import com.petpals.persistence.entities.Breeds;
import com.petpals.persistence.entities.CatBreeds;
import com.petpals.persistence.entities.DogBreeds;
import com.petpals.persistence.entities.NacBreeds;
import com.petpals.shared.model.dto.Breed;
import com.petpals.shared.model.dto.BreedWithoutSpecie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA, uses = {SpeciesMapper.class})
public interface BreedsMapper {
	@Mapping(source="ido.specie.name", target = "specie.name")
	Breed fromEntity(Breeds breed);
	List<Breed> fromEntities(List<Breeds> breed);
	BreedWithoutSpecie fromDogBreedEntity(DogBreeds breed);
	List<BreedWithoutSpecie> fromDogBreedEntities(List<DogBreeds> breed);
	BreedWithoutSpecie fromCatBreedEntity(CatBreeds breed);
	List<BreedWithoutSpecie> fromCatBreedEntities(List<CatBreeds> breed);
	BreedWithoutSpecie fromNacBreedEntity(NacBreeds breed);
	List<BreedWithoutSpecie> fromNacBreedEntities(List<NacBreeds> breed);
}
