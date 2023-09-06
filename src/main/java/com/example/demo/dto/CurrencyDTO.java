package com.example.demo.dto;

import java.io.Serializable;

public class CurrencyDTO implements Serializable {
	
	private static final long serialVersionUID = -3541319811043496467L;
	
	private Long id;
	private String code;
	private String symbol;
	private String description;
	private Boolean enabled;
	private Integer decimalPlaces;
	private AuditDTO audit;//Variable name should be equal to name in Entity
	
	public CurrencyDTO() {}

	public CurrencyDTO(Long id, String code, String symbol, String description, Boolean enabled, Integer decimalPlaces) {
		super();
		this.id = id;
		this.code = code;
		this.symbol = symbol;
		this.description = description;
		this.enabled = enabled;
		this.decimalPlaces = decimalPlaces;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enable) {
		this.enabled = enable;
	}

	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public AuditDTO getAudit() {
		return audit;
	}

	public void setAudit(AuditDTO audit) {
		this.audit = audit;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
