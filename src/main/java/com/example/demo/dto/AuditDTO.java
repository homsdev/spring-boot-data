package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AuditDTO implements Serializable {

	private static final long serialVersionUID = 7346407838354561550L;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

}
