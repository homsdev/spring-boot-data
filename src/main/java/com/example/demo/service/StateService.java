package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StateDTO;
import com.example.demo.mapper.ApiMapper;
import com.example.demo.mapper.StateMapper;
import com.example.demo.model.State;
import com.example.demo.repository.StateRepository;

@Service
public class StateService {

	private final StateRepository stateRepository;

	public StateService(StateRepository stateRepository) {
		super();
		this.stateRepository = stateRepository;
	}
	
	public StateDTO getStateById(Long id) {
		Optional<State> entityState = stateRepository.findById(id);
		
		if(entityState.isPresent()) {
			StateDTO stateDTO = StateMapper.INSTANCE.toDtoWithoutCountry(entityState.get());
			return stateDTO;
		}
		return null;
	}

}
