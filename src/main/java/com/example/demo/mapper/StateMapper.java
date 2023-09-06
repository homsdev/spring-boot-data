package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.StateDTO;
import com.example.demo.model.State;

@Mapper(componentModel = "spring")
public interface StateMapper {

	StateMapper INSTANCE = Mappers.getMapper(StateMapper.class);

	@Named("noCountry")
	@Mapping(target = "country", ignore = true)
	StateDTO toDtoWithoutCountry(State state);

	@Mapping(target = "country", ignore = true)
	StateDTO toStateDto(State state);

	State toStateEntity(StateDTO stateDTO);
}
