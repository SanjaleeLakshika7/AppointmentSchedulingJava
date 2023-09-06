package com.icbt.assignment.consultantservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.AppointmentDetails;
import com.icbt.assignment.consultantservice.entities.Appointments;
 
import com.icbt.assignment.consultantservice.util.CustomException;

public class Appointments_Dao {
	
	public static void Add(DataSource datasource, Appointments appointments) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
		String sql = null;
	    
	    try {
	        con = datasource.getConnection();
	        sql = "INSERT INTO appointments (appointment_id, consultant_id, job_seeker_id, appointment_date, appointment_time,status,job_type_specialization_id,country_specialization_id	) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, appointments.getAppointment_id());
            pstmt.setString(2, appointments.getConsultant_id());
            pstmt.setString(3, appointments.getJob_seeker_id());  
            pstmt.setString(4, appointments.getAppointmentDate());
            pstmt.setString(5, appointments.getAppointmentTime());
            pstmt.setString(6, appointments.getStatus());
            pstmt.setString(7, appointments.getJob_type_specialization_id());
            pstmt.setString(8, appointments.getCountry_specialization_id());
            pstmt.execute();
	        
	    } catch (Exception e) {
	        throw new CustomException(e.getMessage());
	    } finally {
	    	close(con,pstmt,null);
	    }
	     
	}
	
	
	public static List<AppointmentDetails> GetAll(DataSource datasource){
		List<AppointmentDetails> appointmentDetails = new ArrayList<AppointmentDetails>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		try {
			con = datasource.getConnection();
			sql ="SELECT \r\n"
					+ "     \r\n"
					+ "    job_seekers.full_name as job_seekers_full_name,\r\n"
					+ "    job_seekers.contact_number as job_seekers_contact_number,\r\n"
					+ "    job_seekers.email as job_seekers_email,\r\n"
					+ "    job_seekers.address as job_seekers_address,\r\n"
					+ "\r\n"
					+ "    appointments.job_seeker_id,\r\n"
					+ "    appointments.appointment_id ,\r\n"
					+ "    appointments.consultant_id,\r\n"
					+ "    appointments.appointment_date,\r\n"
					+ "    appointments.appointment_time as appointment_time,\r\n"
					+ "    appointments.status,\r\n"
					+ "    appointments.job_type_specialization_id,\r\n"
					+ "    appointments.country_specialization_id,\r\n"
					+ "    \r\n"
					+ "    job_type_specialization.job_type_name as job_type_specialization_job_type_name,\r\n"
					+ "    country_specialization.country_name as country_specialization_country_name,\r\n"
					+ "	\r\n"
					+ "    employee.full_name as  employee_full_name,\r\n"
					+ "    employee.contact_no as  employee_contact_no,\r\n"
					+ "    employee.email as  employee_email \r\n"
					+ "   \r\n"
					+ "FROM \r\n"
					+ "    appointments\r\n"
					+ "INNER JOIN \r\n"
					+ "    job_seekers ON job_seekers.job_seeker_id = appointments.job_seeker_id \r\n"
					+ "INNER JOIN \r\n"
					+ "    job_type_specialization ON job_type_specialization.job_type_specialization_id = appointments.job_type_specialization_id\r\n"
					+ "INNER JOIN \r\n"
					+ "    country_specialization ON country_specialization.country_specialization_id = appointments.country_specialization_id \r\n"
					+ "\r\n"
					+ "LEFT JOIN \r\n"
					+ "    consultants ON consultants.consultant_id = appointments.country_specialization_id \r\n"
					+ "\r\n"
					+ "\r\n"
					+ "LEFT JOIN \r\n"
					+ "    employee ON employee.employee_id = consultants.employee_id; ";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
					 
			  
               String job_seekers_full_name = rset.getString("job_seekers_full_name");
               String job_seekers_contact_number = rset.getString("job_seekers_contact_number");
               String job_seekers_email = rset.getString("job_seekers_email");
               String job_type_specialization_id = rset.getString("job_type_specialization_id");
               String job_seekers_address = rset.getString("job_seekers_address");
               String job_seeker_id = rset.getString("job_seeker_id");
               String consultant_id = rset.getString("consultant_id");
               String appointment_id = rset.getString("appointment_id");
               String appointment_date = rset.getString("appointment_date");
               String appointment_time = rset.getString("appointment_time");
               
               String status = rset.getString("status");
               String country_specialization_id = rset.getString("country_specialization_id");
               String job_type_specialization_job_type_name = rset.getString("job_type_specialization_job_type_name");
               String country_specialization_country_name = rset.getString("country_specialization_country_name");
               
               String employee_full_name = rset.getString("employee_full_name");
               String employee_contact_no = rset.getString("employee_contact_no");
               String employee_email = rset.getString("employee_email");
               
               
               AppointmentDetails aDetails = new AppointmentDetails(job_seekers_full_name,   job_seekers_contact_number,   job_seekers_email,
           			  job_seekers_address,   job_seeker_id,   appointment_id,   consultant_id,
        			  appointment_date,   appointment_time,   status,   job_type_specialization_id,
        			  country_specialization_id,   job_type_specialization_job_type_name,
        			  country_specialization_country_name,   employee_full_name,   employee_contact_no,
        			  employee_email) ;
               appointmentDetails.add(aDetails);
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return appointmentDetails;
	}

	
	
	public static List<AppointmentDetails> GetAppointment(DataSource datasource, String Status, String Job_type_specialization_id , String Country_specialization_id){
		List<AppointmentDetails> appointmentDetails = new ArrayList<AppointmentDetails>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		try {
			con = datasource.getConnection();
			sql ="SELECT \r\n"
					+ "     \r\n"
					+ "    job_seekers.full_name as job_seekers_full_name,\r\n"
					+ "    job_seekers.contact_number as job_seekers_contact_number,\r\n"
					+ "    job_seekers.email as job_seekers_email,\r\n"
					+ "    job_seekers.address as job_seekers_address,\r\n"
					+ "\r\n"
					+ "    appointments.job_seeker_id,\r\n"
					+ "    appointments.appointment_id ,\r\n"
					+ "    appointments.consultant_id,\r\n"
					+ "    appointments.appointment_date,\r\n"
					+ "    appointments.appointment_time as appointment_time,\r\n"
					+ "    appointments.status,\r\n"
					+ "    appointments.job_type_specialization_id,\r\n"
					+ "    appointments.country_specialization_id,\r\n"
					+ "    \r\n"
					+ "    job_type_specialization.job_type_name as job_type_specialization_job_type_name,\r\n"
					+ "    country_specialization.country_name as country_specialization_country_name,\r\n"
					+ "	\r\n"
					+ "    employee.full_name as  employee_full_name,\r\n"
					+ "    employee.contact_no as  employee_contact_no,\r\n"
					+ "    employee.email as  employee_email \r\n"
					+ "   \r\n"
					+ "FROM \r\n"
					+ "    appointments\r\n"
					+ "INNER JOIN \r\n"
					+ "    job_seekers ON job_seekers.job_seeker_id = appointments.job_seeker_id \r\n"
					+ "INNER JOIN \r\n"
					+ "    job_type_specialization ON job_type_specialization.job_type_specialization_id = appointments.job_type_specialization_id\r\n"
					+ "INNER JOIN \r\n"
					+ "    country_specialization ON country_specialization.country_specialization_id = appointments.country_specialization_id \r\n"
					+ "\r\n"
					+ "LEFT JOIN \r\n"
					+ "    consultants ON consultants.consultant_id = appointments.country_specialization_id \r\n"
					+ "\r\n"
					+ "\r\n"
					+ "LEFT JOIN \r\n"
					+ "    employee ON employee.employee_id = consultants.employee_id "
					+ "WHERE appointments.status = ? ";
				 
			stmt = con.prepareStatement(sql);
	 
			stmt.setString(1,Status);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
					 
			  
               String job_seekers_full_name = rset.getString("job_seekers_full_name");
               String job_seekers_contact_number = rset.getString("job_seekers_contact_number");
               String job_seekers_email = rset.getString("job_seekers_email");
               String job_type_specialization_id = rset.getString("job_type_specialization_id");
               String job_seekers_address = rset.getString("job_seekers_address");
               String job_seeker_id = rset.getString("job_seeker_id");
               String consultant_id = rset.getString("consultant_id");
               String appointment_id = rset.getString("appointment_id");
               String appointment_date = rset.getString("appointment_date");
               String appointment_time = rset.getString("appointment_time");
               
               String status = rset.getString("status");
               String country_specialization_id = rset.getString("country_specialization_id");
               String job_type_specialization_job_type_name = rset.getString("job_type_specialization_job_type_name");
               String country_specialization_country_name = rset.getString("country_specialization_country_name");
               
               String employee_full_name = rset.getString("employee_full_name");
               String employee_contact_no = rset.getString("employee_contact_no");
               String employee_email = rset.getString("employee_email");
               
               
               AppointmentDetails aDetails = new AppointmentDetails(job_seekers_full_name,   job_seekers_contact_number,   job_seekers_email,
           			  job_seekers_address,   job_seeker_id,   appointment_id,   consultant_id,
        			  appointment_date,   appointment_time,   status,   job_type_specialization_id,
        			  country_specialization_id,   job_type_specialization_job_type_name,
        			  country_specialization_country_name,   employee_full_name,   employee_contact_no,
        			  employee_email) ;
               appointmentDetails.add(aDetails);
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return appointmentDetails;
	}
	
	
	
	public static void updateAppointment(DataSource dataSource, String consultant_id, String status,String appointment_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			
			con = dataSource.getConnection();
			sql= "UPDATE appointments Set consultant_id =?,status=? where appointment_id=?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, consultant_id);
			pstmt.setString(2, status);
			pstmt.setString(3, appointment_id);
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}

	
	private static void close(Connection con, Statement stmt, ResultSet rset) {
		 try {
			 	if(rset != null)
				{
					rset.close();
				}
				if(stmt != null)
				{
					stmt.close();
				}
				
				if(con != null)
				{
					con.close();
				}
		 }
		 catch (SQLException e) {
			throw new CustomException(e.getMessage());
		}
	}

}
