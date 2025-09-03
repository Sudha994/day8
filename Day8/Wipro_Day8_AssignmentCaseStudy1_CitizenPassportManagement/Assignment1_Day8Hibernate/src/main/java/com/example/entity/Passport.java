package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="passports")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="passport_number", unique=true)
	private String passportNumber;
	
	@OneToOne(mappedBy = "passport")
	private Citizen citizen;
	
	public Passport() {
		// TODO Auto-generated constructor stub
	}

	public Passport(Long id, String passportNumber, Citizen citizen) {
		super();
		this.id = id;
		this.passportNumber = passportNumber;
		this.citizen = citizen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	
}
