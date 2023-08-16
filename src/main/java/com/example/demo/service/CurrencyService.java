package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CurrencyDTO;
import com.example.demo.mapper.ApiMapper;
import com.example.demo.model.Currency;
import com.example.demo.repository.CurrencyRepository;

@Service
public class CurrencyService {
	
	private final CurrencyRepository currencyRepository;
	
	@Autowired
	public CurrencyService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}

	public CurrencyDTO getById(Long id) {
		CurrencyDTO result = null;
		Optional<Currency> currency = currencyRepository.findById(id);
		
		if(currency.isPresent()) {
			result = ApiMapper.INSTANCE.entityToDTO(currency.get());
		}
		
		return result;
	}
	
	public CurrencyDTO save(CurrencyDTO currencyDTO) {
		return currencyDTO;
	}
	
	public CurrencyDTO update(CurrencyDTO currencyDTO) {
		return currencyDTO;
	}
	
	public void delete(Long id) {
		//TODO: deletes currency
	}
	
}
