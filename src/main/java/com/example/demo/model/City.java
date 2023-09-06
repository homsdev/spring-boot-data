package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * City Entity mapped to city table, keeps record of cities
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City extends Base implements Serializable {

	private static final long serialVersionUID = -6623149543514964949L;

	@NotBlank(message = "City's name cannot be empty")
	@Column(name = "name")
	private String name;

	@NotNull(message = "Invalid enabled field")
	@Column(name = "enabled")
	private Boolean enabled = true;// Setting default value

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")
	private State state;

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enabled, name, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(enabled, other.enabled) && Objects.equals(name, other.name)
				&& Objects.equals(state, other.state);
	}
	
}
