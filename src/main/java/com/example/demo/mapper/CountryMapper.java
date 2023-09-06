package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.CountryDTO;
import com.example.demo.mapper.country.CountryWithoutStates;
import com.example.demo.model.Country;

@Mapper(componentModel = "spring")
public interface CountryMapper {
	
	CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
	
	Country toCountryEntity(CountryDTO countryDTO);
		
	@Named("CountryWithoutStates")
	@Mapping(target = "states", ignore=true)
	CountryDTO toDtoWithoutStates(Country country);
}
