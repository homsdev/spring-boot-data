package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/**
 * Inheritance in JPA using MappedSuperclass
 */
@MappedSuperclass // Indicates the class is not a final entity
public abstract class Base implements Serializable {

	private static final long serialVersionUID = -7177310890382049114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private Audit audit;

	public Base() {
	}

	public Base(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	@PrePersist
	public void fillCreatedOn() {
		audit.setCreatedOn(LocalDateTime.now());
	}

	@PreUpdate
	public void fillUpdateOn() {
		audit.setUpdatedOn(LocalDateTime.now());
	}
}
