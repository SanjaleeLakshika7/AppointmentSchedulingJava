package com.icbt.assignment.consultantservice.entities;



public class Appointments {
	
	private String appointment_id ;
	private String consultant_id;
    private String job_seeker_id;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    
    
    private String country_name;
	private String job_type_name;
	private String 	full_name;
	private String contact_number;
	private String 	email;
	
	private String consultantcontactNo;
	  private String ConsultantfullName;
	  
	
    public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getJob_type_name() {
		return job_type_name;
	}
	public void setJob_type_name(String job_type_name) {
		this.job_type_name = job_type_name;
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
	public String getConsultantcontactNo() {
		return consultantcontactNo;
	}
	public void setConsultantcontactNo(String consultantcontactNo) {
		this.consultantcontactNo = consultantcontactNo;
	}
	public String getConsultantfullName() {
		return ConsultantfullName;
	}
	public void setConsultantfullName(String consultantfullName) {
		ConsultantfullName = consultantfullName;
	}
	private String 	job_type_specialization_id;
    private String 	country_specialization_id;
    
	public String getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getConsultant_id() {
		return consultant_id;
	}
	public void setConsultant_id(String consultant_id) {
		this.consultant_id = consultant_id;
	}
	public String getJob_seeker_id() {
		return job_seeker_id;
	}
	public void setJob_seeker_id(String job_seeker_id) {
		this.job_seeker_id = job_seeker_id;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
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

	public Appointments(String appointment_id, String consultant_id, String job_seeker_id, String appointmentDate,
			String appointmentTime, String status, String job_type_specialization_id,
			String country_specialization_id) {
		super();
		this.appointment_id = appointment_id;
		this.consultant_id = consultant_id;
		this.job_seeker_id = job_seeker_id;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.job_type_specialization_id = job_type_specialization_id;
		this.country_specialization_id = country_specialization_id;
	}
	
	
	

	public Appointments(String appointment_id, String consultant_id, String job_seeker_id, String appointmentDate,
			String appointmentTime, String status, String country_name, String job_type_name, String full_name,
			String contact_number, String email, String consultantcontactNo, String consultantfullName,
			String job_type_specialization_id, String country_specialization_id) {
		super();
		this.appointment_id = appointment_id;
		this.consultant_id = consultant_id;
		this.job_seeker_id = job_seeker_id;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.country_name = country_name;
		this.job_type_name = job_type_name;
		this.full_name = full_name;
		this.contact_number = contact_number;
		this.email = email;
		this.consultantcontactNo = consultantcontactNo;
		ConsultantfullName = consultantfullName;
		this.job_type_specialization_id = job_type_specialization_id;
		this.country_specialization_id = country_specialization_id;
	}
	
	
	@Override
	public String toString() {
		return "Appointments [appointment_id=" + appointment_id + ", consultant_id=" + consultant_id
				+ ", job_seeker_id=" + job_seeker_id + ", appointmentDate=" + appointmentDate + ", appointmentTime="
				+ appointmentTime + ", status=" + status + ", country_name=" + country_name + ", job_type_name="
				+ job_type_name + ", full_name=" + full_name + ", contact_number=" + contact_number + ", email=" + email
				+ ", consultantcontactNo=" + consultantcontactNo + ", ConsultantfullName=" + ConsultantfullName
				+ ", job_type_specialization_id=" + job_type_specialization_id + ", country_specialization_id="
				+ country_specialization_id + "]";
	}
	
	
    

}
