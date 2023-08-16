package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CountryDTO;
import com.example.demo.mapper.ApiMapper;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

@Service
public class CountryService {

	private final CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}

	public CountryDTO getCountryById(Long id) {
		CountryDTO result = null;

		Optional<Country> country = countryRepository.findById(id);

		if (country.isPresent()) {
			result = ApiMapper.INSTANCE.entityToDTO(country.get());
		}

		return result;
	}

}
