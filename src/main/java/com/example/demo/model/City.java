package com.example.demo.model;

import java.io.Serializable;

public class City implements Serializable {

	private Long id;
	private String name;
	private Boolean enabled;

	public City(Long id, String name, Boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
