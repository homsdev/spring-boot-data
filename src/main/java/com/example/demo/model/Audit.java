package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * This class is embeddable inside another entity and fields will appear as
 * columns of the same table
 */
@Embeddable
public class Audit implements Serializable {

	private static final long serialVersionUID = -2906180493165397334L;

	@Column(name = "created_on", nullable = false)
	private LocalDateTime createdOn;

	@Column(name = "updated_on", nullable = true)
	private LocalDateTime updatedOn;

	public Audit() {
	}

	public Audit(LocalDateTime createdOn, LocalDateTime updatedOn) {
		super();
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(createdOn, updatedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audit other = (Audit) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(updatedOn, other.updatedOn);
	}

}
