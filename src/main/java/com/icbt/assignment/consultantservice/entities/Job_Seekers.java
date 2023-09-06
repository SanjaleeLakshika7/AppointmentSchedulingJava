package com.icbt.assignment.consultantservice.entities;

import javax.validation.constraints.NotBlank;

public class Job_Seekers {
	
	@NotBlank(message = "is Required")
	private String job_seeker_id;
	
	@NotBlank(message = "is Required")
	private String 	full_name;
	
	@NotBlank(message = "is Required")
	private String contact_number;
	
	@NotBlank(message = "is Required")
	private String 	email;
	
	@NotBlank(message = "is Required")
	private String 	address	;

	public String getJob_seeker_id() {
		return job_seeker_id;
	}

	public void setJob_seeker_id(String job_seeker_id) {
		this.job_seeker_id = job_seeker_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Job_Seekers(String job_seeker_id, String full_name, String contact_number, String email, String address) {
		super();
		this.job_seeker_id = job_seeker_id;
		this.full_name = full_name;
		this.contact_number = contact_number;
		this.email = email;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Job_Seekers [job_seeker_id=" + job_seeker_id + ", full_name=" + full_name + ", contact_number="
				+ contact_number + ", email=" + email + ", address=" + address + "]";
	}
	
	
	
	
	
}
