package com.example.demo.dto;

public class ViolationDTO {

	private String field;
	private String message;

	public ViolationDTO(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public ViolationDTO() {
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
