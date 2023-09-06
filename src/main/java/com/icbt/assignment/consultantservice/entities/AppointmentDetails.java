package com.icbt.assignment.consultantservice.entities;

public class AppointmentDetails {
    private String job_seekers_full_name;
    private String job_seekers_contact_number;
    private String job_seekers_email;
    private String job_seekers_address;

    private String job_seeker_id;
    private String appointment_id;
    private String consultant_id;
    private String appointment_date;
    private String appointment_time;
    private String status;
    private String job_type_specialization_id;
    private String country_specialization_id;

    private String job_type_specialization_job_type_name;
    private String country_specialization_country_name;

    private String employee_full_name;
    private String employee_contact_no;
    private String employee_email;
    
	public String getJob_seekers_full_name() {
		return job_seekers_full_name;
	}
	public void setJob_seekers_full_name(String job_seekers_full_name) {
		this.job_seekers_full_name = job_seekers_full_name;
	}
	public String getJob_seekers_contact_number() {
		return job_seekers_contact_number;
	}
	public void setJob_seekers_contact_number(String job_seekers_contact_number) {
		this.job_seekers_contact_number = job_seekers_contact_number;
	}
	public String getJob_seekers_email() {
		return job_seekers_email;
	}
	public void setJob_seekers_email(String job_seekers_email) {
		this.job_seekers_email = job_seekers_email;
	}
	public String getJob_seekers_address() {
		return job_seekers_address;
	}
	public void setJob_seekers_address(String job_seekers_address) {
		this.job_seekers_address = job_seekers_address;
	}
	public String getJob_seeker_id() {
		return job_seeker_id;
	}
	public void setJob_seeker_id(String job_seeker_id) {
		this.job_seeker_id = job_seeker_id;
	}
	public String getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(String Appointment_id) {
		this.appointment_id = Appointment_id;
	}
	public String getConsultant_id() {
		return consultant_id;
	}
	public void setConsultant_id(String consultant_id) {
		this.consultant_id = consultant_id;
	}
	public String getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(String Appointment_date) {
		this.appointment_date = Appointment_date;
	}
	public String getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(String Appointment_time) {
		this.appointment_time = Appointment_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getJob_type_specialization_job_type_name() {
		return job_type_specialization_job_type_name;
	}
	public void setJob_type_specialization_job_type_name(String job_type_specialization_job_type_name) {
		this.job_type_specialization_job_type_name = job_type_specialization_job_type_name;
	}
	public String getCountry_specialization_country_name() {
		return country_specialization_country_name;
	}
	public void setCountry_specialization_country_name(String country_specialization_country_name) {
		this.country_specialization_country_name = country_specialization_country_name;
	}
	public String getEmployee_full_name() {
		return employee_full_name;
	}
	public void setEmployee_full_name(String employee_full_name) {
		this.employee_full_name = employee_full_name;
	}
	public String getEmployee_contact_no() {
		return employee_contact_no;
	}
	public void setEmployee_contact_no(String employee_contact_no) {
		this.employee_contact_no = employee_contact_no;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
 
	public AppointmentDetails(String job_seekers_full_name, String job_seekers_contact_number, String job_seekers_email,
			String job_seekers_address, String job_seeker_id, String Appointment_id, String consultant_id,
			String Appointment_date, String Appointment_time, String status, String job_type_specialization_id,
			String country_specialization_id, String job_type_specialization_job_type_name,
			String country_specialization_country_name, String employee_full_name, String employee_contact_no,
			String employee_email) {
		super();
		this.job_seekers_full_name = job_seekers_full_name;
		this.job_seekers_contact_number = job_seekers_contact_number;
		this.job_seekers_email = job_seekers_email;
		this.job_seekers_address = job_seekers_address;
		this.job_seeker_id = job_seeker_id;
		this.appointment_id = Appointment_id;
		this.consultant_id = consultant_id;
		this.appointment_date = Appointment_date;
		this.appointment_time = Appointment_time;
		this.status = status;
		this.job_type_specialization_id = job_type_specialization_id;
		this.country_specialization_id = country_specialization_id;
		this.job_type_specialization_job_type_name = job_type_specialization_job_type_name;
		this.country_specialization_country_name = country_specialization_country_name;
		this.employee_full_name = employee_full_name;
		this.employee_contact_no = employee_contact_no;
		this.employee_email = employee_email;
	}
	@Override
	public String toString() {
		return "AppointmentDetails [job_seekers_full_name=" + job_seekers_full_name + ", job_seekers_contact_number="
				+ job_seekers_contact_number + ", job_seekers_email=" + job_seekers_email + ", job_seekers_address="
				+ job_seekers_address + ", job_seeker_id=" + job_seeker_id + ", Appointment_id=" + appointment_id
				+ ", consultant_id=" + consultant_id + ", Appointment_date=" + appointment_date + ", Appointment_time="
				+ appointment_time + ", status=" + status + ", job_type_specialization_id=" + job_type_specialization_id
				+ ", country_specialization_id=" + country_specialization_id
				+ ", job_type_specialization_job_type_name=" + job_type_specialization_job_type_name
				+ ", country_specialization_country_name=" + country_specialization_country_name
				+ ", employee_full_name=" + employee_full_name + ", employee_contact_no=" + employee_contact_no
				+ ", employee_email=" + employee_email + "]";
	}

    
}

