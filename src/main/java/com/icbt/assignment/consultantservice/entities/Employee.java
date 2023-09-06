package com.icbt.assignment.consultantservice.entities;

import javax.validation.constraints.NotBlank;

public class Employee {
	
	private String employee_id;
	@NotBlank(message = "is Required")
    private String fullName;
	@NotBlank(message = "is Required")
    private String dob;
	@NotBlank(message = "is Required")
    private String nic;
	@NotBlank(message = "is Required")
    private String userType;
	@NotBlank(message = "is Required")
    private String address;
	@NotBlank(message = "is Required")
    private String contactNo;
	@NotBlank(message = "is Required")
    private String email;
	@NotBlank(message = "is Required")
    private String password;

	private String consultant_id;
	private String job_type_name;
	private String country_name;
	
	private String country_specialization_id;
	private String job_type_specialization_id;

	public String getConsultant_id() {
		return consultant_id;
	}

	public String getCountry_specialization_id() {
		return country_specialization_id;
	}

	public void setCountry_specialization_id(String country_specialization_id) {
		this.country_specialization_id = country_specialization_id;
	}

	public String getJob_type_specialization_id() {
		return job_type_specialization_id;
	}

	public void setJob_type_specialization_id(String job_type_specialization_id) {
		this.job_type_specialization_id = job_type_specialization_id;
	}

	public void setConsultant_id(String consultant_id) {
		this.consultant_id = consultant_id;
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

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Employee() {
		super();
	}
 
	public Employee(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

 
	public Employee(String employee_id, String fullName, String dob, String nic, String userType, String address,
			String contactNo, String email, String password) {
		super();
		this.employee_id = employee_id;
		this.fullName = fullName;
		this.dob = dob;
		this.nic = nic;
		this.userType = userType;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}
	

 

	/**
	 * @param employee_id
	 * @param fullName
	 * @param dob
	 * @param nic
	 * @param userType
	 * @param address
	 * @param contactNo
	 * @param email
	 * @param password
	 * @param consultant_id
	 * @param job_type_name
	 * @param country_name
	 * @param country_specialization_id
	 * @param job_type_specialization_id
	 */
	public Employee(String employee_id, String fullName,
			  String dob,  String nic,
			  String userType,  String address,
			  String contactNo,   String email,
			  String password, String consultant_id, String job_type_name,
			String country_name, String country_specialization_id, String job_type_specialization_id) {
		super();
		this.employee_id = employee_id;
		this.fullName = fullName;
		this.dob = dob;
		this.nic = nic;
		this.userType = userType;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.consultant_id = consultant_id;
		this.job_type_name = job_type_name;
		this.country_name = country_name;
		this.country_specialization_id = country_specialization_id;
		this.job_type_specialization_id = job_type_specialization_id;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employee_id + ", fullName=" + fullName + ", dob=" + dob + ", nic=" + nic
				+ ", userType=" + userType + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email
				+ ", password=" + password + "]";
	}
    
	
	
	
    

}
