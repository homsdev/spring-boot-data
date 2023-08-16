package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Each entity needs a primary key Entites need to have a constructor without
 * arguments Classes must not be declared final All attributes need to have a
 * getter and setter
 */
@Entity // This annotation indicates to JPA that it's something that has a persistent
		// state
@Table(name = "country") // This annotation is optionally when the table's name is the same in the DB
public class Country implements Serializable {

	@Id
	private Long id;
	private String code;
	private String name;
	private String locale;
	private String timeZone;
	private Boolean enabled;

	public Country() {
		super();
	}

	public Country(Long id, String code, String name, String locale, String timeZone, Boolean enabled) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.locale = locale;
		this.timeZone = timeZone;
		this.enabled = enabled;
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

}
