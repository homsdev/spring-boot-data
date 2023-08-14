package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

	public CurrencyDTO getById(Long id) {
		return new CurrencyDTO(id, "USD","Dollar",true,2);
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
