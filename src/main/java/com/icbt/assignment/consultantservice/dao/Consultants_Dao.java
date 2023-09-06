package com.icbt.assignment.consultantservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.Consultants;

import com.icbt.assignment.consultantservice.util.CustomException;

public class Consultants_Dao {
	
	public static List<Consultants> GetAll(DataSource datasource){
		List<Consultants> consultants = new ArrayList<Consultants>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		try {
			con = datasource.getConnection();
			sql ="SELECT consultant_id, consultants.employee_id, consultants.country_specialization_id, consultants.job_type_specialization_id,\r\n"
					+ "employee.full_name,dob,nic, address,contact_no,country_specialization.country_name, job_type_specialization.job_type_name  \r\n"
					+ "FROM consultants\r\n"
					+ "inner join employee on employee.employee_id = consultants.employee_id\r\n"
					+ "inner join job_type_specialization on job_type_specialization.job_type_specialization_id = consultants.job_type_specialization_id\r\n"
					+ "inner join country_specialization on country_specialization.country_specialization_id = consultants.country_specialization_id;";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
					 
			   String consultant_id = rset.getString("consultant_id");
               String employee_id = rset.getString("employee_id");
               String country_specialization_id = rset.getString("country_specialization_id");
               String job_type_specialization_id = rset.getString("job_type_specialization_id");
               
               String fullName = rset.getString("full_name");
               String dob = rset.getString("dob");
               String nic = rset.getString("nic");
               String userType = "";
               String address = rset.getString("address");
               String contactNo = rset.getString("contact_no");
               String job_type_name = rset.getString("job_type_name");
               String country_name = rset.getString("country_name");
              
               
        
               Consultants consultant = new Consultants(  consultant_id,
         			    employee_id,
        			    job_type_specialization_id,
        			    country_specialization_id,   fullName,   dob,
        			  nic,   userType,   address,   contactNo,   job_type_name,   country_name);
               consultants.add(consultant);
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
		finally {
			close(con,stmt,rset);
		}
		return consultants;
	}
	
	public static void Add(DataSource datasource, Consultants consultant) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
		String sql = null;
	    
	    try {
	        con = datasource.getConnection();
	        sql = "INSERT INTO consultants (consultant_id, employee_id, country_specialization_id, job_type_specialization_id) VALUES (?, ?, ?, ?)";
	        
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, consultant.getConsultant_id());
            pstmt.setString(2, consultant.getEmployee_id());
            pstmt.setString(3, consultant.getCountry_specialization_id());  // Assuming dob is a java.util.Date
            pstmt.setString(4, consultant.getJob_type_specialization_id());
            
            pstmt.execute();
	        
	    } catch (Exception e) {
	        throw new CustomException(e.getMessage());
	    } finally {
	    	close(con,pstmt,null);
	    }
	     
	}
	
	public static void Delete(DataSource dataSource, String consultant_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "DELETE FROM  consultants  WHERE consultant_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, consultant_id);
		 	
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
