package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.CurrencyDTO;
import com.example.demo.model.Country;
import com.example.demo.model.Currency;

@Mapper(componentModel = "spring")
public interface ApiMapper {
	ApiMapper INSTANCE = Mappers.getMapper(ApiMapper.class);
	CurrencyDTO entityToDTO(Currency currency);
	Currency DTOToEntity(CurrencyDTO currency);
	
	CountryDTO entityToDTO(Country country);
	Country DTOToEntity(CountryDTO countryDTO);
}
