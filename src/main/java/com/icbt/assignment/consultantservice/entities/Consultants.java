package com.icbt.assignment.consultantservice.entities;

import javax.validation.constraints.NotBlank;

public class Consultants {
	@NotBlank(message = "is Required")
	private String consultant_id;
	
	@NotBlank(message = "is Required")
	private String employee_id;
	
	@NotBlank(message = "is Required")
	private String job_type_specialization_id;

	@NotBlank(message = "is Required")
	private String country_specialization_id;
	 
    private String fullName;
 
    private String dob;

    private String nic;

    private String userType;

    private String address;
	
    private String contactNo;

	private String job_type_name;
	
	private String country_name;

	public String getConsultant_id() {
		return consultant_id;
	}

	public void setConsultant_id(String consultant_id) {
		this.consultant_id = consultant_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getJob_type_specialization_id() {
		return job_type_specialization_id;
	}

	public void setJob_type_specialization_id(String job_type_specialization_id) {
		this.job_type_specialization_id = job_type_specialization_id;
	}

	public String getCountry_specialization_id() {
		return country_specialization_id;
	}

	public void setCountry_specialization_id(String country_specialization_id) {
		this.country_specialization_id = country_specialization_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getJob_type_name() {
		return job_type_name;
	}

	public void setJob_type_name(String job_type_name) {
		this.job_type_name = job_type_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}


	public Consultants(String consultant_id, String employee_id, String job_type_specialization_id,
			String country_specialization_id) {
		super();
		this.consultant_id = consultant_id;
		this.employee_id = employee_id;
		this.job_type_specialization_id = job_type_specialization_id;
		this.country_specialization_id = country_specialization_id;
	}
	

	/**
	 * @param consultant_id
	 * @param employee_id
	 * @param job_type_specialization_id
	 * @param country_specialization_id
	 * @param fullName
	 * @param dob
	 * @param nic
	 * @param userType
	 * @param address
	 * @param contactNo
	 * @param job_type_name
	 * @param country_name
	 */
	public Consultants( String consultant_id,
			  String employee_id,
			  String job_type_specialization_id,
			  String country_specialization_id, String fullName, String dob,
			String nic, String userType, String address, String contactNo, String job_type_name, String country_name) {
		super();
		this.consultant_id = consultant_id;
		this.employee_id = employee_id;
		this.job_type_specialization_id = job_type_specialization_id;
		this.country_specialization_id = country_specialization_id;
		this.fullName = fullName;
		this.dob = dob;
		this.nic = nic;
		this.userType = userType;
		this.address = address;
		this.contactNo = contactNo;
		this.job_type_name = job_type_name;
		this.country_name = country_name;
	}

	@Override
	public String toString() {
		return "Consultants [consultant_id=" + consultant_id + ", employee_id=" + employee_id
				+ ", job_type_specialization_id=" + job_type_specialization_id + ", country_specialization_id="
				+ country_specialization_id + ", fullName=" + fullName + ", dob=" + dob + ", nic=" + nic + ", userType="
				+ userType + ", address=" + address + ", contactNo=" + contactNo + ", job_type_name=" + job_type_name
				+ ", country_name=" + country_name + "]";
	}
	
	
	
	
	
  
}
