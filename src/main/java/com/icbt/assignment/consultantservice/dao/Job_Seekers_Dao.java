package com.icbt.assignment.consultantservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.icbt.assignment.consultantservice.entities.Job_Seekers;
import com.icbt.assignment.consultantservice.util.CustomException;

public class Job_Seekers_Dao {
	
	public static void Add(DataSource datasource, Job_Seekers job_Seekers) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
		String sql = null;
	    
	    try {
	        con = datasource.getConnection();
	        sql = "INSERT INTO job_Seekers (job_seeker_id, full_name, contact_number, email, address) VALUES (?, ?, ?, ?, ?)";
	        
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, job_Seekers.getJob_seeker_id());
            pstmt.setString(2, job_Seekers.getFull_name());
            pstmt.setString(3, job_Seekers.getContact_number());  
            pstmt.setString(4, job_Seekers.getEmail());
            pstmt.setString(5, job_Seekers.getAddress());

            pstmt.execute();
	        
	    } catch (Exception e) {
	        throw new CustomException(e.getMessage());
	    } finally {
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
