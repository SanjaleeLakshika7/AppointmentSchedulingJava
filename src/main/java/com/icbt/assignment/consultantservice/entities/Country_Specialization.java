package com.icbt.assignment.consultantservice.entities;

import javax.validation.constraints.NotBlank;

public class Country_Specialization {
	
	private String country_specialization_id;
	@NotBlank(message = "is Required")
	private String country_name;
	
	public String getCountry_specialization_id() {
		return country_specialization_id;
	}
	public void setCountry_specialization_id(String country_specialization_id) {
		this.country_specialization_id = country_specialization_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Country_Specialization() {
		super();
	}
	
	public Country_Specialization(String country_specialization_id, String country_name) {
		super();
		this.country_specialization_id = country_specialization_id;
		this.country_name = country_name;
	}
	
	@Override
	public String toString() {
		return "Country_Specialization [country_specialization_id=" + country_specialization_id + ", country_name="
				+ country_name + "]";
	}
	
	
	
	
}
