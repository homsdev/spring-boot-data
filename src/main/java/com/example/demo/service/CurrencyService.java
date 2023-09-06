package com.example.demo.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CurrencyDTO;
import com.example.demo.mapper.ApiMapper;
import com.example.demo.model.Currency;
import com.example.demo.repository.CurrencyRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class CurrencyService {

	private final CurrencyRepository currencyRepository;
	private final Validator validator;

	public CurrencyService(CurrencyRepository currencyRepository, Validator validator) {
		this.currencyRepository = currencyRepository;
		this.validator = validator;
	}

	public CurrencyDTO getById(Long id) {
		CurrencyDTO result = null;
		Optional<Currency> currency = currencyRepository.findById(id);

		if (currency.isPresent()) {
			result = ApiMapper.INSTANCE.entityToDTO(currency.get());
		}

		return result;
	}

	public CurrencyDTO save(CurrencyDTO currencyDTO) {
		Currency currency = ApiMapper.INSTANCE.DTOToEntity(currencyDTO);
		Set<ConstraintViolation<Currency>> violations = validator.validate(currency);
		if(!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
		Currency savedEntity = currencyRepository.save(currency);		
		return ApiMapper.INSTANCE.entityToDTO(savedEntity);
	}

	public CurrencyDTO update(CurrencyDTO currencyDTO) {
		return currencyDTO;
	}

	public void delete(Long id) {
		// TODO: deletes currency
	}

}
