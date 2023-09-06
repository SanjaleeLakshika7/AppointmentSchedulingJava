package com.icbt.assignment.consultantservice.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.dao.Appointments_Dao;
 
import com.icbt.assignment.consultantservice.entities.AppointmentDetails;
import com.icbt.assignment.consultantservice.entities.Appointments;
 

public class Appointments_Services {
	
	public static void Add(DataSource datasource, Appointments appointments) {
		Appointments_Dao.Add(datasource, appointments);
	}
	
	public static List<AppointmentDetails> GetAll(DataSource datasource){
		return Appointments_Dao.GetAll(datasource);
	}
	
	public static List<AppointmentDetails> GetAppointment(DataSource datasource, String Status, String Job_type_specialization_id , String Country_specialization_id){
		return Appointments_Dao.GetAppointment(datasource, Status, Job_type_specialization_id, Country_specialization_id); 
	}
	
	public static void updateAppointment(DataSource dataSource, String consultant_id, String status,String appointment_id) {
		Appointments_Dao.updateAppointment(dataSource, consultant_id, status, appointment_id);
	}
}
