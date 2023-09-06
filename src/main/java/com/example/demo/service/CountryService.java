package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CountryDTO;
import com.example.demo.mapper.ApiMapper;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

/**
 * If class is annotated with spring bean and has only one constructor
 * the @autowired annotation can be ommited
 */
@Service
public class CountryService {

	private final CountryRepository countryRepository;

	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public CountryDTO getCountryById(Long id) {
		CountryDTO result = null;

		Optional<Country> country = countryRepository.findById(id);

		if (country.isPresent()) {
			result = null;
		}

		return result;
	}

	/**
	 * Returns a country without currency info
	 * @param id
	 * @return countryDTO without currency info
	 */
	public CountryDTO getCountryWithoutCurrencyById(Long id) {
		CountryDTO result = null;
		Optional<Country> countryOpt = countryRepository.findById(id);

		if (countryOpt.isPresent()) {
			result = CountryMapper.INSTANCE.toDTOWithoutCurrency(countryOpt.get());
		}
		return result;
	}
	
	public CountryDTO getCountryWhitoutStatesById(Long id) {
		CountryDTO result = null;
		Optional<Country> countryOpt = countryRepository.findById(id);

		if (countryOpt.isPresent()) {
			result = CountryMapper.INSTANCE.toCountryDTO(countryOpt.get());
		}
		return result;
	}

}
