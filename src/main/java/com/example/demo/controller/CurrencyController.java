package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CurrencyDTO;
import com.example.demo.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

	private CurrencyService currencyService;

	@Autowired
	public CurrencyController(CurrencyService currencyService) {
		super();
		this.currencyService = currencyService;
	}
	
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<CurrencyDTO> getById(@PathVariable Long id) {
		CurrencyDTO response = currencyService.getById(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CurrencyDTO> save(@RequestBody CurrencyDTO currencyDTO){
		CurrencyDTO response = currencyService.save(currencyDTO);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CurrencyDTO> update(@PathVariable Long id, @RequestBody CurrencyDTO currencyDTO) {
		CurrencyDTO response = currencyService.update(currencyDTO);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		currencyService.delete(id);	
		return new ResponseEntity<>(HttpStatus.OK);
	}

	

}
