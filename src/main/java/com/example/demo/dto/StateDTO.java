package com.example.demo.dto;

public class StateDTO {

	private Long id;
	private String code;
	private String name;
	private Boolean enabled;

	public StateDTO(Long id, String code, String name, Boolean enabled) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
