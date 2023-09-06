package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.State;

@Repository
public interface StateRepository extends CrudRepository<State,Long>{
	
}
