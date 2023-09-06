/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * 
 */
@Entity
@Table(name = "currency") // Optional only if you need to indicate the table's name
@AttributeOverride(name = "id", column = @Column(name = "currency_id", nullable = false)) // Override inherited
																							// attribute name in DB
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Currency extends Base implements Serializable {

	private static final long serialVersionUID = 3321134241387908672L;

	@NotBlank(message = "Code is mandatory")
	private String code;
	
	@NotBlank(message = "Symbol is mandatory")
	private String symbol;
	
	@NotBlank(message = "Description is mandatory")
	private String description;
	
	//TODO: Solve this bug
	private Boolean enabled = Boolean.TRUE;

	@Min(value = 1, message = "The minumum value is 1")
	@Max(value = 5, message = "The maximun value is 5")
	@Column(name = "decimal_places") // Optional: Indicate name and length of the column
	private int decimalPlaces;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "currency")
	private Country country;

	public Currency() {
		super();
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

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public int getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, decimalPlaces, description, enabled);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		return Objects.equals(code, other.code) && decimalPlaces == other.decimalPlaces
				&& Objects.equals(description, other.description) && Objects.equals(enabled, other.enabled);
	}
}
