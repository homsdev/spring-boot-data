package com.example.demo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Each entity needs a primary key, Entities need to have a constructor without
 * arguments, Classes must not be declared final, All attributes need to have a
 * getter and setter
 */
@Entity // This annotation indicates to JPA that it's something that has a persistent
		// state
@Table(name = "country") // This annotation is optionally when the table's name is the same in the DB
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Country extends Base implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(name = "code", nullable = false, length = 4)
	private String code;

	@NotBlank
	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@NotBlank
	@Column(name = "locale", nullable = false, length = 6)
	private String locale;

	@NotBlank
	@Column(name = "time_zone", nullable = false, length = 10) // Length only for strings
	private String timeZone;

	// @Transient//Indicates that the attribute does not need to be persisted in DB
	@OneToOne(fetch = FetchType.LAZY) // lazy by standard and retrieve with getMethod
	@JoinColumn(name = "currency_id", nullable = false)
	private Currency currency;

	@NotNull
	@Column(name = "enabled", nullable = false)
	private Boolean enabled = Boolean.TRUE;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	@OrderBy(value = "id") // Order by column criteria by execute a query with ordering
	private List<State> states;

	public Country() {
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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, currency, enabled, locale, name, states, timeZone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(code, other.code) && Objects.equals(currency, other.currency)
				&& Objects.equals(enabled, other.enabled) && Objects.equals(locale, other.locale)
				&& Objects.equals(name, other.name) && Objects.equals(states, other.states)
				&& Objects.equals(timeZone, other.timeZone);
	}
}
