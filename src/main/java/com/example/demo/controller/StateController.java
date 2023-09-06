package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StateDTO;
import com.example.demo.service.StateService;

@RestController
@RequestMapping(path = "state")
public class StateController {

	private final StateService stateService;

	public StateController(StateService stateService) {
		this.stateService = stateService;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StateDTO> getStateById(@PathVariable Long id) {
		StateDTO dto = stateService.getStateById(id);
		return new ResponseEntity<StateDTO>(dto, HttpStatus.OK);
	}

}
