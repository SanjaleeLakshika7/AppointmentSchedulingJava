package com.icbt.assignment.consultantservice.entities;

import javax.validation.constraints.NotBlank;

public class JobType {
	private String job_type_specialization_id;
	@NotBlank(message = "is Required")
	private String job_type_name;

	public String getJob_type_specialization_id() {
		return job_type_specialization_id;
	}

	public void setJob_type_specialization_id(String job_type_specialization_id) {
		this.job_type_specialization_id = job_type_specialization_id;
	}

	public String getJob_type_name() {
		return job_type_name;
	}

	public void setJob_type_name(String job_type_name) {
		this.job_type_name = job_type_name;
	}

 
	 
	public JobType() {
		super();
	}

	public JobType(String job_type_specialization_id, String job_type_name) {
		super();
		this.job_type_specialization_id = job_type_specialization_id;
		this.job_type_name = job_type_name;
	}

	@Override
	public String toString() {
		return "JobType [job_type_specialization_id=" + job_type_specialization_id + ", job_type_name=" + job_type_name
				+ "]";
	}
	
	
	
	
}
