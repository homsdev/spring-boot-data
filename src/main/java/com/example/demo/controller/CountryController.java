package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CountryDTO;
import com.example.demo.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	private final CountryService countryService;

	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
		return new ResponseEntity<>(countryService.getCountryById(id),HttpStatus.OK);
	}*/
	
	@GetMapping(value = "{id}")
	public ResponseEntity<CountryDTO> getCountryWithoutCurrency(@PathVariable Long id) {
		return new ResponseEntity<>(countryService.getCountryWhitoutStatesById(id),HttpStatus.OK);
	}


}
