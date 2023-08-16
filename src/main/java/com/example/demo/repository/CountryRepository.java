package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Country;

public interface CountryRepository  extends CrudRepository<Country, Long	>{

}
