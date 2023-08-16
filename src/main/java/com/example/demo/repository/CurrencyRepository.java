
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long>{
	//General Queries
	List<Currency> findByCode(String code);
	List<Currency> findByCodeAndDescription(String code,String description);
	
	//Order Queries
	List<Currency> findByDescriptionOrderByCodeAsc(String description);
	List<Currency> findByDescriptionOrderByCodeDesc(String description);
	
	//Manual Query
	@Query("SELECT c FROM Currency c WHERE c.code = :code")
	Currency retrieveByCode(@Param("code") String code);
}
