package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

public class CountryDTO implements Serializable{

	private static final long serialVersionUID = -7127107059040098121L;
	
	private Long id;
	private String code;
	private String name;
	private String locale;
	private String timeZone;
	private Boolean enabled;
	private CurrencyDTO currency;
	private List<StateDTO> states;

	public CountryDTO(Long id, String code, String name, String locale, String timeZone, Boolean enabled,
			CurrencyDTO currency, List<StateDTO> states) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.locale = locale;
		this.timeZone = timeZone;
		this.enabled = enabled;
		this.currency = currency;
		this.states = states;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public CurrencyDTO getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyDTO currency) {
		this.currency = currency;
	}

	public List<StateDTO> getStates() {
		return states;
	}

	public void setStates(List<StateDTO> states) {
		this.states = states;
	}

}
